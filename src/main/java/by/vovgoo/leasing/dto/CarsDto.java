package by.vovgoo.leasing.dto;

import by.vovgoo.leasing.dto.baseDto.EditableDto;
import by.vovgoo.leasing.entity.enums.CarColor;
import by.vovgoo.leasing.entity.enums.CarStatus;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CarsDto extends EditableDto<Long> {

    private Long id;

    private String make;

    private String model;

    private Integer year;

    private CarColor color;

    private Double mileage;

    private Double price;

    private CarStatus carStatus;

    private String description;

    private String image;
}
