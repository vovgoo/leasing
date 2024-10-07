package by.vovgoo.leasing.controllers;

import by.vovgoo.leasing.dto.pages.CarInfoPage.CarInfoPageMaintenanceDto;
import by.vovgoo.leasing.dto.pages.utils.PageResponse;
import by.vovgoo.leasing.service.MaintenanceService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/maintenance")
public class MaintenanceController {

    private final MaintenanceService maintenanceService;
    @GetMapping
    public PageResponse<CarInfoPageMaintenanceDto> getCarsInfoPage(@PathParam("carId") Long carId, @PathParam("pageNumber") Long pageNumber) {
        return maintenanceService.getCarMaintenanceByCarId(carId, pageNumber);
    }
}
