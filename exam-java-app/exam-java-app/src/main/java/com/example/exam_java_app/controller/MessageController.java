package com.example.exam_java_app.controller;

import com.example.exam_java_app.model.Message;
import com.example.exam_java_app.model.User;
import com.example.exam_java_app.repository.UserRepository;
import com.example.exam_java_app.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class MessageController {
    private final MessageService messageService;
    private final UserRepository userRepository;

    public MessageController(MessageService messageService, UserRepository userRepository) {
        this.messageService = messageService;
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String showMessagePage(Model model) {
        return "message";
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String userName, @RequestParam String userMessage, Model model) {
        Message message = messageService.saveMessage(userName, userMessage);
        model.addAttribute("response", message.getResponse());

        return "message";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);

        return "users";
    }

    @GetMapping("/users/{id}/messages")
    public String showUserMessages(@PathVariable Integer id, Model model) {
        User user = userRepository.findById(id).orElse(null);

        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("messages", user.getMessages());
        }

        return "user-messages";
    }
}
