package com.example.exam_java_api.service;

import com.example.exam_java_api.model.Quote;
import com.example.exam_java_api.repository.QuoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteService {
    private final QuoteRepository quoteRepository;
    private final Random random = new Random();

    public QuoteService(QuoteRepository quoteRepository) {
        this.quoteRepository = quoteRepository;
    }

    public Quote getRandomQuote() {
        List<Quote> quotes = quoteRepository.findAll();
        return quotes.isEmpty() ? new Quote("Pas de citation disponible.") : quotes.get(random.nextInt(quotes.size()));
    }
}