package by.vovgoo.leasing.service;

import by.vovgoo.leasing.dto.JwtAuthResponse;
import by.vovgoo.leasing.dto.RentalsPersonalDto;
import by.vovgoo.leasing.entity.RentalsPersonal;
import by.vovgoo.leasing.dto.SignInRequest;
import by.vovgoo.leasing.dto.UserDto;

import java.util.List;

public interface AuthService {

    UserDto signUp(UserDto userDto);

    JwtAuthResponse signIn(SignInRequest signInRequest);
}
