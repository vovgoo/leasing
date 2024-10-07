package by.vovgoo.leasing.controllers;

import by.vovgoo.leasing.dto.pages.OrderPersonalPage.OrderPersonaPageDto;
import by.vovgoo.leasing.service.PaymentsService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/payments")
public class PaymentsController {

    private final PaymentsService paymentsService;

    @GetMapping("/order")
    public OrderPersonaPageDto getOrderPersonal(@PathParam("id") Long id) {
        return paymentsService.getOrderById(id);
    }
}
