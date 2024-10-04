package by.vovgoo.leasing.entity;

import by.vovgoo.leasing.entity.baseEntity.EditableEntity;
import by.vovgoo.leasing.entity.enums.CarStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
@Table(name = "cars")
@Builder
public class Cars extends EditableEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String make;

    @NotBlank
    private String model;

    @NotBlank
    @Size(min = 4, max = 4)
    private Integer year;

    @NotBlank
    private String color;

    @NotBlank
    private Double mileage;

    @NotBlank
    @Min(0)
    private Double price;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private CarStatus carStatus;

    @NotBlank
    private String description;

    @NotBlank
    private String image;

}
