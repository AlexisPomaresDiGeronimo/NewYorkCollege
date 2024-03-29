package com.alexis.MessagingWebSocket.Repositories;

import com.alexis.MessagingWebSocket.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User,Integer> {
   User getUserByUsername(String username);
}