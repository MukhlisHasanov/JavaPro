package de.ait.user_service.service;

import de.ait.user_service.dto.UserResponseDto;
import de.ait.user_service.entity.User;

import de.ait.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Locale.filter;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<UserResponseDto> getAll() {
        return UserResponseDto.of(repository.findAll());
    }

    @Override
    public List<UserResponseDto> getByName(String name) {
        return getAll()
                .stream()
                .filter(user->user.getName().equals(name))
                .toList();
    }

    @Override
    public UserResponseDto getById(Long id) {
        User findUser = repository
                .findAll()
                .stream()
                .filter(user -> user.getId().equals(id))
                .findAny()
                .get();
        return UserResponseDto.of(findUser);
    }

    @Override
    public UserResponseDto save(User user) {
        return UserResponseDto.of(repository.save(user));
    }

    @Override
    public UserResponseDto delete(Long id) {
        return UserResponseDto.of(repository.delete(id));
    }

    @Override
    public UserResponseDto update(Long id) {
        return UserResponseDto.of(repository.save(user));
    }
}