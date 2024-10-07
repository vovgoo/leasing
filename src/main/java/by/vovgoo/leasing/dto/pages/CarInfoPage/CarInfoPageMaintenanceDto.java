package by.vovgoo.leasing.dto.pages.CarInfoPage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarInfoPageMaintenanceDto {

    private Long id;

    private String serviceName;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

}
