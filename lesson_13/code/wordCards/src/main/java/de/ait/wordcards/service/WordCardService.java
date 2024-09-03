package de.ait.wordcards.service;

import de.ait.wordcards.entity.WordCard;

import java.util.List;

public interface WordCardService {
    List<WordCard> getAllWordCards();
    WordCard createNewWordCard(WordCard word);
    WordCard updateWordCard(Long id, WordCard word);
    WordCard deleteWordCard(Long id);






}
