package by.vovgoo.leasing.entity;

import by.vovgoo.leasing.entity.baseEntity.EditableEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
@SuperBuilder
public class Maintenance extends EditableEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cars cars;

    @NotBlank
    private String description;

    @NotBlank
    @Min(0)
    private Double cost;

    @NotBlank
    private String serviceName;

    @NotBlank
    @DateTimeFormat
    private LocalDateTime startDate;

    @NotBlank
    @DateTimeFormat
    private LocalDateTime endDate;

}

