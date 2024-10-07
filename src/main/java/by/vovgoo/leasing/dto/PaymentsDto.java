package by.vovgoo.leasing.dto;

import by.vovgoo.leasing.dto.baseDto.EditableDto;
import by.vovgoo.leasing.entity.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class PaymentsDto extends EditableDto<Long> {

    private Long id;

    private RentalsDto rentals;

    private UserDto user;

    private Double amount;

    private PaymentMethod paymentMethod;
}
