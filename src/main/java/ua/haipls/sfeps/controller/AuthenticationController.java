package ua.haipls.sfeps.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.haipls.sfeps.domain.AuthenticationRequest;

@RestController
@RequestMapping("/auth/login")
public class AuthenticationController {

    @PostMapping()
    public void login(@RequestBody AuthenticationRequest authenticationRequest) {
    }
}