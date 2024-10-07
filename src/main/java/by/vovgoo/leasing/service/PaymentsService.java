package by.vovgoo.leasing.service;

import by.vovgoo.leasing.dto.pages.OrderPersonalPage.OrderPersonaPageDto;

public interface PaymentsService {

    OrderPersonaPageDto getOrderById(Long id);

}
