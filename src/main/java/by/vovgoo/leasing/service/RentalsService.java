package by.vovgoo.leasing.service;

import by.vovgoo.leasing.dto.pages.UserPersonalPage.UserPersonalPageRentalsDto;
import by.vovgoo.leasing.dto.pages.utils.PageResponse;

public interface RentalsService {
    PageResponse<UserPersonalPageRentalsDto> getUserRentals(Long pageNumber);
}
