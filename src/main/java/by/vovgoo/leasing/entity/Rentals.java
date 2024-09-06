package by.vovgoo.leasing.entity;

import by.vovgoo.leasing.entity.baseEntity.EditableEntity;
import by.vovgoo.leasing.entity.enums.RentalsStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
public class Rentals extends EditableEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Cars cars;

    @NotBlank
    @DateTimeFormat
    private LocalDateTime startDate;

    @NotBlank
    @DateTimeFormat
    private LocalDateTime endDate;

    @NotBlank
    private RentalsStatus rentalsStatus;

}
