package by.vovgoo.leasing.controllers;

import by.vovgoo.leasing.dto.pages.CarInfoPage.CarsInfoPage;
import by.vovgoo.leasing.dto.pages.MainPage.MainPageDto;
import by.vovgoo.leasing.service.CarsService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/cars")
public class CarsController {

    private final CarsService carsService;
    @GetMapping
    public CarsInfoPage getCarsInfoPage(@PathParam("id") Long id) {
        return carsService.getCarsInfoPage(id);
    }

    @GetMapping("/mainPage")
    public MainPageDto getMainPage() {
        return carsService.getMainPage();
    }
}
