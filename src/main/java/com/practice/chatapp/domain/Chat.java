package com.practice.chatapp.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "chat")  // collection명 지정
public class Chat {
    @Id
    private String id;          // Bson타입이 아닌 String 타입으로 지정
    private String msg;
    private String sender;      // 전송자
    private String receiver;    // 수신자(귓속말)
    private Integer roomNum;    // 방번호

    private LocalDateTime createdAt;
}
