package com.alexis.MessagingWebSocket.Controllers;

import com.alexis.MessagingWebSocket.Models.User;
import com.alexis.MessagingWebSocket.Repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class PagesController {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String registration(Model model){
        model.addAttribute("title","Create Account");
        return "register";
    }
    @PostMapping("/register")
    public String register(HttpServletRequest request , Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cnf_pass = request.getParameter("cnf_password");
        User user = userRepo.getUserByUsername(username);
        if (!password.equals(cnf_pass)){
            model.addAttribute("msg" , "Insert the same password and confirm password!!");
            return "register";
        }else if(user != null){
            if(username.equals(user.getUsername())){
                model.addAttribute("msg" , "This Username already exists!!");
            }
            return "register";
        }
        else{
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(passwordEncoder.encode(password));
            newUser.setRole("ROLE_USER");
            userRepo.save(newUser);
            return "login";
        }
    }
    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("title","Sign In");
        return "login";
    }
    @GetMapping("/chat")
    public String chat(Model model){
        model.addAttribute("title","Web Sockets Chat");
        return "chat";
    }
    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("title","Administrator Page");
        return "admin";
    }
}
