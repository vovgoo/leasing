package by.vovgoo.leasing.dto;

import by.vovgoo.leasing.entity.Cars;
import by.vovgoo.leasing.entity.enums.RentalsStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalsPersonalDto {

    private Long id;

    private CarsDto cars;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private RentalsStatus rentalsStatus;

}
