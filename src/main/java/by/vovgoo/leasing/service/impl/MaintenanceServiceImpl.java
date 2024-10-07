package by.vovgoo.leasing.service.impl;

import by.vovgoo.leasing.dto.pages.CarInfoPage.CarInfoPageMaintenanceDto;
import by.vovgoo.leasing.dto.pages.utils.PageResponse;
import by.vovgoo.leasing.repositories.MaintenanceRepository;
import by.vovgoo.leasing.service.MaintenanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;

    @Override
    public PageResponse<CarInfoPageMaintenanceDto> getCarMaintenanceByCarId(Long id, Long pageNumber) {
        return PageResponse.of(maintenanceRepository.findMaintenanceByCars(id, PageRequest.of(Math.toIntExact(pageNumber), 10)).map(obj -> new CarInfoPageMaintenanceDto(obj.getId(), obj.getServiceName(), obj.getStartDate(), obj.getEndDate())));
    }

}
