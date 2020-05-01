package ua.haipls.sfeps.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.haipls.sfeps.dto.UserDto;
import ua.haipls.sfeps.dto.UserRegisterDto;
import ua.haipls.sfeps.dto.mapper.UserMapper;
import ua.haipls.sfeps.service.RegistrationService;
import ua.haipls.sfeps.service.UserService;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final UserService userService;
    private final UserMapper userMapper;
    @Override
    public boolean register(UserRegisterDto dto) {
        log.info("Trying  register - user: {} ", dto);
        UserDto userDto = userMapper.toDto(dto);
        userService.create(userDto);
        return true;
    }
}
