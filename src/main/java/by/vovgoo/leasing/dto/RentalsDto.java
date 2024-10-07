package by.vovgoo.leasing.dto;

import by.vovgoo.leasing.dto.baseDto.EditableDto;
import by.vovgoo.leasing.entity.enums.RentalsStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class RentalsDto extends EditableDto<Long> {

    private Long id;

    private UserDto user;

    private CarsDto cars;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private RentalsStatus rentalsStatus;
}
