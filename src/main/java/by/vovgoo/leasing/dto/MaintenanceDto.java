package by.vovgoo.leasing.dto;

import by.vovgoo.leasing.dto.baseDto.EditableDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class MaintenanceDto extends EditableDto<Long> {

    private Long id;

    private CarsDto cars;

    private String description;

    private Double cost;

    private String serviceName;

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
