package by.vovgoo.leasing.service.impl;

import by.vovgoo.leasing.dto.JwtAuthResponse;
import by.vovgoo.leasing.dto.RentalsPersonalDto;
import by.vovgoo.leasing.entity.RentalsPersonal;
import by.vovgoo.leasing.dto.SignInRequest;
import by.vovgoo.leasing.dto.UserDto;
import by.vovgoo.leasing.entity.User;
import by.vovgoo.leasing.entity.enums.Role;
import by.vovgoo.leasing.mapper.RentalsPersonalMapper;
import by.vovgoo.leasing.mapper.UserMapper;
import by.vovgoo.leasing.repositories.RentalsRepository;
import by.vovgoo.leasing.repositories.UserRepository;
import by.vovgoo.leasing.service.AuthService;
import by.vovgoo.leasing.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    public UserDto signUp(UserDto userDto) {
        User user = userMapper.mapTo(userDto);
        user.setRole(Role.USER);
        user.setPasswordHash(passwordEncoder.encode(user.getPassword()));
        return Optional.of(user).map(userRepository::save).map(userMapper::mapFrom).orElseThrow();
    }

    @Override
    public JwtAuthResponse signIn(SignInRequest signInRequest) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),
                signInRequest.getPassword()));

        var user = userRepository.findByUsername(signInRequest.getUsername()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);

        JwtAuthResponse jwtAuthenticationResponse = new JwtAuthResponse();
        jwtAuthenticationResponse.setToken(jwt);
        return jwtAuthenticationResponse;
    }
}
