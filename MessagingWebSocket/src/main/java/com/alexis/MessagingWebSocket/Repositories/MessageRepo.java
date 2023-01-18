package com.alexis.MessagingWebSocket.Repositories;

import com.alexis.MessagingWebSocket.Models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface MessageRepo extends JpaRepository<Message, Integer> {
    Message getMessageByMessageId(Integer messageId);
}
