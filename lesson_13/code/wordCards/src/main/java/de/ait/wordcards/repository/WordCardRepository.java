package de.ait.wordcards.repository;

import de.ait.wordcards.entity.WordCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface WordCardRepository extends JpaRepository<WordCard, Long>{
    List<WordCard> findByWord(String word);
    List<WordCard> findByWordContaining(String word);
    List<WordCard> findByWordContainingIgnoreCase(String word);
    List<WordCard> findByWordContainingIgnoreCaseAndWord(String word, String word2);

}
