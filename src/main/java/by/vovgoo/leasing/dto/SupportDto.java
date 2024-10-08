package by.vovgoo.leasing.dto;

import by.vovgoo.leasing.dto.baseDto.EditableDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class SupportDto extends EditableDto<Long> {

    private Long id;

    private UserDto user;

    private String subject;
}
