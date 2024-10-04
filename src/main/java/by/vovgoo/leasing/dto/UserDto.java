package by.vovgoo.leasing.dto;

import by.vovgoo.leasing.entity.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;

    private String username;

    @JsonIgnore
    private String passwordHash;

    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address;

    private String image;

    private Role role;
}
