package ua.haipls.sfeps.service;

import ua.haipls.sfeps.dto.UserRegisterDto;

public interface RegistrationService {
    boolean register(UserRegisterDto dto);
}
