package com.example.exam_java_api.controller;

import com.example.exam_java_api.model.Quote;
import com.example.exam_java_api.service.QuoteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quote")
public class QuoteController {
    private final QuoteService quoteService;

    public QuoteController(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping
    public Quote getQuote() {
        return quoteService.getRandomQuote();
    }
}
