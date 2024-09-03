package de.ait.wordcards.service;

import de.ait.wordcards.entity.WordCard;
import de.ait.wordcards.repository.WordCardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class WordCardServiceImpl implements WordCardService {

    private final WordCardRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<WordCard> getAllWordCards() {
        return repository.findAll()
                .stream()
                .map(w->mapper.map(w, WordCard.class))
                .toList();
    }

    @Override
    public WordCard createNewWordCard(WordCard word) {
        WordCard entity = mapper.map(word, WordCard.class);
        entity = repository.save(entity);
        return mapper.map(entity, WordCard.class);
    }

    @Override
    @Transactional
    public WordCard updateWordCard(Long id, WordCard word) {
        return null;
    }

    @Override
    public WordCard deleteWordCard(Long id) {
        return null;
    }
}
