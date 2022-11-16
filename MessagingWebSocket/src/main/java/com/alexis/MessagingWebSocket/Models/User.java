package com.alexis.MessagingWebSocket.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class User  {
    public String Username;
    @Id
    public String Email;
    public String Password;
    @OneToMany
    public List<Message> messages;


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public User() {
    }

    public User(String username, String email, String password) {
        this.Username = username;
        this.Email = email;
        this.Password = password;
    }
}
