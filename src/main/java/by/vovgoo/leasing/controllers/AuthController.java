package by.vovgoo.leasing.controllers;

import by.vovgoo.leasing.dto.JwtAuthResponse;
import by.vovgoo.leasing.dto.RentalsPersonalDto;
import by.vovgoo.leasing.entity.RentalsPersonal;
import by.vovgoo.leasing.dto.SignInRequest;
import by.vovgoo.leasing.dto.UserDto;
import by.vovgoo.leasing.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
