package com.practice.chatapp.repository;

import com.practice.chatapp.domain.Chat;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface ChatRepository extends ReactiveMongoRepository<Chat, String> {
    // Flux(흐름)
    // 데이터를 1번 받는 것이 아닌 계속 흘려서 받겠다
    // resposne를 유지하면서 데이터를 계속 흘려보낼 수 있다.
    @Tailable   // 커서를 안닥고 계속 유지한다(데이터를 조회하고나서 닫히지 않고 계속 흘러들어온다)
    @Query("{sender: ?0, receiver: ?1}")    // mongodb의 문법
    Flux<Chat> mFindBySender(String sender, String receiver);

    @Tailable
    @Query("{roomNum: ?0}")
    Flux<Chat> mFindByRoomNum(Integer roomNum);
}
