package by.vovgoo.leasing.controllers;

import by.vovgoo.leasing.dto.auth.JwtAuthResponse;
import by.vovgoo.leasing.dto.auth.SignInRequest;
import by.vovgoo.leasing.dto.UserDto;
import by.vovgoo.leasing.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signUp")
    public UserDto signUp(@Validated @RequestBody UserDto userDto) {
        return authService.signUp(userDto);
    }

    @PostMapping("/signIn")
    public JwtAuthResponse signIn(@Validated @RequestBody SignInRequest signInRequest) {
        return authService.signIn(signInRequest);
    }

}
