package by.vovgoo.leasing.service;

import by.vovgoo.leasing.dto.pages.CarInfoPage.CarInfoPageMaintenanceDto;
import by.vovgoo.leasing.dto.pages.utils.PageResponse;

public interface MaintenanceService {
    PageResponse<CarInfoPageMaintenanceDto> getCarMaintenanceByCarId(Long id, Long pageNumber);
}
