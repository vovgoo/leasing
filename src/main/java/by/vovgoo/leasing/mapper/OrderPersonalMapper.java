package by.vovgoo.leasing.mapper;

import by.vovgoo.leasing.dto.OrderPersonalDto;
import by.vovgoo.leasing.entity.OrderPersonal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderPersonalMapper implements Mapper<OrderPersonal, OrderPersonalDto> {

    private final PaymentsMapper paymentsMapper;

    @Override
    public OrderPersonal mapTo(OrderPersonalDto object) {
        return OrderPersonal.builder()
                .payments(paymentsMapper.mapTo(object.getPayments()))
                .build();
    }

    @Override
    public OrderPersonalDto mapFrom(OrderPersonal object) {
        return OrderPersonalDto.builder()
                .payments(paymentsMapper.mapFrom(object.getPayments()))
                .build();
    }
}
