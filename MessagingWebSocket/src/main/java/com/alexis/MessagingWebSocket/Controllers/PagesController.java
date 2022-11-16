package com.alexis.MessagingWebSocket.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {
    @GetMapping("/chat")
   public String index(Model model){
        model.addAttribute("title","Chat");
        return "chat";
    }
    @GetMapping("/")
    public String login(Model model){
        model.addAttribute("title","Welcome | Login");
        return "singIn";
    }
    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("title","Register");
        return "register";
    }
}
