package de.ait.wordcards.controller;

import de.ait.wordcards.entity.WordCard;
import de.ait.wordcards.service.WordCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class WordCardController {

    private final WordCardService service;

    @GetMapping("/wordcards")
    public List<WordCard> getAllWordCards() {
        return service.getAllWordCards();
    }

    @PostMapping("/wordcards")
    public WordCard createNewWordCard(WordCard word) {
        return service.createNewWordCard(word);
    }

    public WordCard updateWordCard(Long id, WordCard word) {
        return null;
    }

    public WordCard deleteWordCard(Long id) {
        return null;
    }
}
