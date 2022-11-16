package com.alexis.MessagingWebSocket.Models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Message {
    @Id
    public Long Id;
    public String MessageContext;
    public Date DateOfPublic;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Email")
    public Message message;



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMessageContext() {
        return MessageContext;
    }

    public void setMessageContext(String messageContext) {
        MessageContext = messageContext;
    }

    public Date getDateOfPublic() {
        return DateOfPublic;
    }

    public void setDateOfPublic(Date dateOfPublic) {
        DateOfPublic = dateOfPublic;
    }

    public Message() {
    }

    public Message(Long id, String messageContext, Date dateOfPublic) {
        Id = id;
        MessageContext = messageContext;
        DateOfPublic = dateOfPublic;
    }
}
