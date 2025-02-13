package com.example.exam_java_app.service;

import com.example.exam_java_app.dto.QuoteDTO;
import com.example.exam_java_app.model.Message;
import com.example.exam_java_app.model.User;
import com.example.exam_java_app.repository.MessageRepository;
import com.example.exam_java_app.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public MessageService(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
        this.restTemplate = new RestTemplate();
    }

    public Message saveMessage(String userName, String userMessage) {
        User user = userRepository.findByUserName(userName);

        if (user == null) {
            user = new User(userName);
            userRepository.save(user);
        }

        QuoteDTO quote = restTemplate.getForObject("http://localhost:8080/api/quote", QuoteDTO.class);

        String quoteMessage = "Pas de citation.";

        if (quote != null) {
            quoteMessage = quote.getMessage();
        }

        Message message = new Message(user, userMessage, quoteMessage);
        return messageRepository.save(message);
    }
}
