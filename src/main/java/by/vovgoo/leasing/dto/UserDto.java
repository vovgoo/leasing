package by.vovgoo.leasing.dto;

import by.vovgoo.leasing.dto.baseDto.EditableDto;
import by.vovgoo.leasing.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class UserDto extends EditableDto<Long> {

    private Long id;

    private String username;

    private String passwordHash;

    private String email;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String address;

    private String image;

    private Role role;
}
