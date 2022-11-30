package com.alexis.MessagingWebSocket.Controllers;

import com.alexis.MessagingWebSocket.Models.User;
import com.alexis.MessagingWebSocket.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private BCryptPasswordEncoder pwdEncoder;
    @PostMapping("/saveUser")
    public String saveUser(User user) {
        String encryptPass = pwdEncoder.encode(user.getPassword());
        user.setPassword(encryptPass);
        userRepo.save(user);
        return "signIn";
    }
}
