package com.alexis.MessagingWebSocket.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class  User  {
    @Id
    @GeneratedValue(generator="user_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="user_seq", sequenceName = "user_seq", allocationSize = 1)
    private int userId;
    private String username;
    private String password;
    private String role;     //ROLE_ + name <-- save database

    //    @OneToMany
    //    private List<Message> messages;


}
