package by.vovgoo.leasing.service.impl;

import by.vovgoo.leasing.dto.pages.OrderPersonalPage.OrderPersonaPageDto;
import by.vovgoo.leasing.entity.Payments;
import by.vovgoo.leasing.entity.User;
import by.vovgoo.leasing.repositories.PaymentsRepository;
import by.vovgoo.leasing.service.PaymentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentsServiceImpl implements PaymentsService {

    private final PaymentsRepository paymentsRepository;

    private final OrderPersonalPageMapper orderPersonaPageMapper;

    @Component
    public static class OrderPersonalPageMapper {

        public OrderPersonaPageDto map(Payments payments) {
            return OrderPersonaPageDto.builder()
                    .cars(
                            OrderPersonaPageDto.OrderCars.builder()
                                    .id(payments.getRentals().getCars().getId())
                                    .make(payments.getRentals().getCars().getMake())
                                    .model(payments.getRentals().getCars().getModel())
                                    .year(payments.getRentals().getCars().getYear())
                                    .color(payments.getRentals().getCars().getColor())
                                    .mileage(payments.getRentals().getCars().getMileage())
                                    .price(payments.getRentals().getCars().getPrice())
                                    .image(payments.getRentals().getCars().getImage())
                                    .build()
                    )
                    .rentals(
                            OrderPersonaPageDto.OrderRentals.builder()
                                    .id(payments.getRentals().getId())
                                    .startDate(payments.getRentals().getStartDate())
                                    .endDate(payments.getRentals().getEndDate())
                                    .rentalsStatus(payments.getRentals().getRentalsStatus())
                                    .build()
                    )
                    .payments(
                            OrderPersonaPageDto.OrderPayments.builder()
                                    .id(payments.getId())
                                    .amount(payments.getAmount())
                                    .paymentMethod(payments.getPaymentMethod())
                                    .build()
                    )
                    .orderUser(
                            OrderPersonaPageDto.OrderUser.builder()
                                    .id(payments.getUser().getId())
                                    .firstname(payments.getUser().getFirstName())
                                    .build()
                    )
                    .build();
        }
    }


    @Override
    public OrderPersonaPageDto getOrderById(Long id) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        OrderPersonaPageDto orderPersonal = paymentsRepository.getOrderPersonalById(id).map(orderPersonaPageMapper::map).orElseThrow();

        if(!orderPersonal.getOrderUser().getId().equals(user.getId())) {
            throw new AccessDeniedException("You not have permissions");
        }

        return orderPersonal;
    }
}
