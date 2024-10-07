package by.vovgoo.leasing.controllers;

import by.vovgoo.leasing.dto.pages.UserPersonalPage.UserPersonalPageRentalsDto;
import by.vovgoo.leasing.dto.pages.utils.PageResponse;
import by.vovgoo.leasing.service.RentalsService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/rentals")
public class RentalsController {

    private final RentalsService rentalsService;

    @GetMapping
    public PageResponse<UserPersonalPageRentalsDto> getUserRentals(@PathParam("pageNumber") Long pageNumber) {
        return rentalsService.getUserRentals(pageNumber);
    }
}
