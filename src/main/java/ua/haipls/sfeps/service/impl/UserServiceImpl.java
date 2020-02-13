package ua.haipls.sfeps.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.haipls.sfeps.domain.Role;
import ua.haipls.sfeps.domain.User;
import ua.haipls.sfeps.domain.domainEnum.UserStatus;
import ua.haipls.sfeps.dto.UserDto;
import ua.haipls.sfeps.dto.mapper.UserMapper;
import ua.haipls.sfeps.repositoriy.RoleRepository;
import ua.haipls.sfeps.repositoriy.UserRepository;
import ua.haipls.sfeps.service.UserService;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDto create(UserDto userDto) {
        Role roleUser = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new EntityNotFoundException("Role not found by name: "));

        userDto.setRoles(Collections.singleton(roleUser));
        userDto.setStatus(UserStatus.NOT_ACTIVED);

        User user = userRepository.save(userMapper.toEntity(userDto));
        UserDto result = userMapper.toDto(user);

        log.info("IN create - user: {} successfully created", result);

        return result;
    }

    @Override
    public UserDto update(UserDto userDto) {
        findById(userDto.getId());

        User user = userRepository.save(userMapper.toEntity(userDto));
        UserDto result = userMapper.toDto(user);
        log.info("IN update - user: {} successfully updated", result);

        return result;
    }

    @Override
    public Collection<UserDto> findAll() {
        Collection<UserDto> result = ((Collection<User>) userRepository.findAll())
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
        log.info("IN findAll - {} users found", result.size());
        return result;
    }

    @Override
    public UserDto findById(Long id) {
        UserDto result = userMapper.toDto(userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found by id: " + id)));
        log.info("IN findById - user: {} found by id: {}", result, id);
        return result;
    }

    @Override
    public UserDto findByEmail(String email) {
        UserDto result = userMapper.toDto(userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User not found by email: " + email)));
        log.info("IN findById - user: {} found by email: {}", result, email);
        return result;
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        userRepository.setDeletedStatusById(id);
        log.info("IN deleteById - user with id: {} successfully deleted", id);
    }
}
