package com.alexis.MessagingWebSocket.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Message {
   @Id
   @GeneratedValue(generator="message_seq", strategy = GenerationType.SEQUENCE)
   @SequenceGenerator(name="message_seq", sequenceName = "message_seq", allocationSize = 1)
   private int messageId;
   private String message;
   private Instant timestamp;
//   @ManyToOne(fetch = FetchType.LAZY)
//   private User user;
}
