package ua.haipls.sfeps.service;

import ua.haipls.sfeps.dto.UserDto;

import java.util.Collection;

public interface UserService {

    UserDto create(UserDto userDto);

    UserDto update(UserDto userDto);

    Collection<UserDto> findAll();

    UserDto findById(Long id);

    UserDto findByEmail(String email);

    void deleteById(Long id);
}
