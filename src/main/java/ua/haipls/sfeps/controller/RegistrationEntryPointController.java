package ua.haipls.sfeps.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.haipls.sfeps.dto.UserDto;
import ua.haipls.sfeps.dto.UserRegisterDto;
import ua.haipls.sfeps.service.RegistrationService;

@RestController
@RequestMapping("/auth/registration")
@RequiredArgsConstructor
public class RegistrationEntryPointController {

    private final RegistrationService registrationService;

    @PostMapping()
    public boolean register(@RequestBody UserRegisterDto dto) {

        return registrationService.register(dto);
    }
}
