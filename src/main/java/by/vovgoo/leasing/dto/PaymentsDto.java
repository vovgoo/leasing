package by.vovgoo.leasing.dto;

import by.vovgoo.leasing.entity.Rentals;
import by.vovgoo.leasing.entity.User;
import by.vovgoo.leasing.entity.enums.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentsDto {
    private Long id;

    private RentalsDto rentals;

    @JsonIgnore
    private UserDto user;

    private Double amount;

    private PaymentMethod paymentMethod;
}
