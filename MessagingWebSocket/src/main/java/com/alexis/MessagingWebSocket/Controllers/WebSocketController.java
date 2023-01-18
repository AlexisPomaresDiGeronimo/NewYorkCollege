package com.alexis.MessagingWebSocket.Controllers;

import com.alexis.MessagingWebSocket.Models.Message;
import com.alexis.MessagingWebSocket.Repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class WebSocketController {
    @Autowired
    private MessageRepo messageRepo;
    @MessageMapping("/chat")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message chatMessage) {
        messageRepo.save(chatMessage);
        return chatMessage;
    }
}