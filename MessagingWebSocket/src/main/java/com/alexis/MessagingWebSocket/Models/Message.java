package com.alexis.MessagingWebSocket.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Message {
    @Id
    public Long messageId;
    public String messageContext;
    public Date dateOfPublic;
}
