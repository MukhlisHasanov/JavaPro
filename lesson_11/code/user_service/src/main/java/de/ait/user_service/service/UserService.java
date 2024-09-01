package de.ait.user_service.service;

import de.ait.user_service.dto.UserResponseDto;
import de.ait.user_service.entity.User;

import java.util.List;


public interface UserService {
    public List<UserResponseDto> getAll();
    public List<UserResponseDto> getByName(String name);
    public UserResponseDto getById(Long id);
    public UserResponseDto save(User user);
    public UserResponseDto delete(Long id);
    public UserResponseDto update(User user);

    UserResponseDto update(Long id);
}
