package by.vovgoo.leasing.mapper;

import by.vovgoo.leasing.dto.MaintenanceDto;
import by.vovgoo.leasing.entity.Maintenance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MaintenanceMapper implements Mapper<Maintenance, MaintenanceDto> {

    private final CarsMapper carsMapper;
    @Override
    public Maintenance mapTo(MaintenanceDto object) {
        return Maintenance.builder()
                .id(object.getId())
                .cars(carsMapper.mapTo(object.getCars()))
                .description(object.getDescription())
                .cost(object.getCost())
                .serviceName(object.getServiceName())
                .startDate(object.getStartDate())
                .endDate(object.getEndDate())
                .createdAt(object.getCreatedAt())
                .updatedAt(object.getUpdatedAt())
                .build();
    }

    @Override
    public MaintenanceDto mapFrom(Maintenance object) {
        return MaintenanceDto.builder()
                .id(object.getId())
                .cars(carsMapper.mapFrom(object.getCars()))
                .description(object.getDescription())
                .cost(object.getCost())
                .serviceName(object.getServiceName())
                .startDate(object.getStartDate())
                .endDate(object.getEndDate())
                .createdAt(object.getCreatedAt())
                .updatedAt(object.getUpdatedAt())
                .build();
    }
}
