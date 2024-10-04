package by.vovgoo.leasing.dto;

import by.vovgoo.leasing.entity.enums.CarStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarsDto {
    private Long id;

    private String make;

    private String model;

    private Integer year;

    private String color;

    private Double mileage;

    private Double price;

    private CarStatus carStatus;

    private String description;

    private String image;
}
