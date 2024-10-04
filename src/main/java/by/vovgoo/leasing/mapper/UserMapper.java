package by.vovgoo.leasing.mapper;

import by.vovgoo.leasing.dto.UserDto;
import by.vovgoo.leasing.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDto> {

    @Override
    public User mapTo(UserDto object) {
        return User.builder()
                .id(object.getId())
                .username(object.getUsername())
                .passwordHash(object.getPasswordHash())
                .email(object.getEmail())
                .firstName(object.getFirstName())
                .lastName(object.getLastName())
                .phoneNumber(object.getPhoneNumber())
                .address(object.getAddress())
                .image(object.getImage())
                .role(object.getRole())
                .build();
    }

    @Override
    public UserDto mapFrom(User object) {
        return UserDto.builder()
                .id(object.getId())
                .username(object.getUsername())
                .passwordHash(object.getPasswordHash())
                .email(object.getEmail())
                .firstName(object.getFirstName())
                .lastName(object.getLastName())
                .phoneNumber(object.getPhoneNumber())
                .address(object.getAddress())
                .image(object.getImage())
                .role(object.getRole())
                .build();
    }
}
