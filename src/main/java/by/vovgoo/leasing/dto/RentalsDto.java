package by.vovgoo.leasing.dto;

import by.vovgoo.leasing.entity.Cars;
import by.vovgoo.leasing.entity.User;
import by.vovgoo.leasing.entity.enums.RentalsStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentalsDto {

    private Long id;

    private UserDto user;

    private CarsDto cars;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private RentalsStatus rentalsStatus;
}
