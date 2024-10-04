package by.vovgoo.leasing.entity;

import by.vovgoo.leasing.entity.baseEntity.EditableEntity;
import by.vovgoo.leasing.entity.enums.PaymentMethod;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
@Builder
public class Payments extends EditableEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private Rentals rentals;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull
    private User user;

    @NotBlank
    @Min(0)
    private Double amount;

    @Enumerated(EnumType.STRING)
    @NotBlank
    private PaymentMethod paymentMethod;
}
