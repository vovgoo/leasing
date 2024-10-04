package by.vovgoo.leasing.entity;

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
public class RentalsPersonal {

    private Long id;

    private Cars cars;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private RentalsStatus rentalsStatus;

}
