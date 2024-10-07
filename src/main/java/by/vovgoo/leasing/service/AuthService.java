package by.vovgoo.leasing.service;

import by.vovgoo.leasing.dto.auth.JwtAuthResponse;
import by.vovgoo.leasing.dto.auth.SignInRequest;
import by.vovgoo.leasing.dto.UserDto;

public interface AuthService {

    UserDto signUp(UserDto userDto);

    JwtAuthResponse signIn(SignInRequest signInRequest);
}
