package by.vovgoo.leasing.dto.pages.OrderPersonalPage;

import by.vovgoo.leasing.dto.PaymentsDto;
import by.vovgoo.leasing.entity.enums.CarStatus;
import by.vovgoo.leasing.entity.enums.PaymentMethod;
import by.vovgoo.leasing.entity.enums.RentalsStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderPersonaPageDto {

    private OrderCars cars;

    private OrderRentals rentals;

    private OrderPayments payments;

    private OrderUser orderUser;


    @Data
    @Builder
    public static class OrderCars {

        private Long id;

        private String make;

        private String model;

        private Integer year;

        private String color;

        private Double mileage;

        private Double price;

        private String image;

    }

    @Data
    @Builder
    public static class OrderRentals {

        private Long id;

        private LocalDateTime startDate;

        private LocalDateTime endDate;

        private RentalsStatus rentalsStatus;
    }

    @Data
    @Builder
    public static class OrderPayments {

        private Long id;

        private Double amount;

        private PaymentMethod paymentMethod;
    }

    @Data
    @Builder
    public static class OrderUser {

        Long id;

        String firstname;
    }

}
