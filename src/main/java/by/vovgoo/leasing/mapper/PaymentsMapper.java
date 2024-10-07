package by.vovgoo.leasing.mapper;

import by.vovgoo.leasing.dto.PaymentsDto;
import by.vovgoo.leasing.entity.Payments;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentsMapper implements Mapper<Payments, PaymentsDto> {

    private final RentalsMapper rentalsMapper;

    private final UserMapper userMapper;

    @Override
    public Payments mapTo(PaymentsDto object) {
        return Payments.builder()
                .id(object.getId())
                .rentals(rentalsMapper.mapTo(object.getRentals()))
                .user(userMapper.mapTo(object.getUser()))
                .amount(object.getAmount())
                .paymentMethod(object.getPaymentMethod())
                .createdAt(object.getCreatedAt())
                .updatedAt(object.getUpdatedAt())
                .build();
    }

    @Override
    public PaymentsDto mapFrom(Payments object) {
        return PaymentsDto.builder()
                .id(object.getId())
                .rentals(rentalsMapper.mapFrom(object.getRentals()))
                .user(userMapper.mapFrom(object.getUser()))
                .amount(object.getAmount())
                .paymentMethod(object.getPaymentMethod())
                .createdAt(object.getCreatedAt())
                .updatedAt(object.getUpdatedAt())
                .build();
    }
}
