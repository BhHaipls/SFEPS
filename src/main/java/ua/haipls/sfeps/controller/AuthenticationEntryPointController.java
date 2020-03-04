package ua.haipls.sfeps.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.haipls.sfeps.security.JwtTokenProvider;
import ua.haipls.sfeps.security.UserPrincipal;
import ua.haipls.sfeps.security.dto.AuthenticationRequest;
import ua.haipls.sfeps.security.dto.AuthenticationResponse;

@RestController
@RequestMapping("/auth/login")
@RequiredArgsConstructor
public class AuthenticationEntryPointController {

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;
    @PostMapping()
    public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            return new AuthenticationResponse(jwtTokenProvider
                    .generateToken((UserPrincipal) authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    authenticationRequest.getEmail(),
                                    authenticationRequest.getPassword())).getPrincipal()));
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Unauthorized");
        }
    }
}