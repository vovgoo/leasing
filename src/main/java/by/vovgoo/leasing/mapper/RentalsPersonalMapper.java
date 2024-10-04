package by.vovgoo.leasing.mapper;

import by.vovgoo.leasing.dto.RentalsPersonalDto;
import by.vovgoo.leasing.entity.RentalsPersonal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RentalsPersonalMapper implements Mapper<RentalsPersonal, RentalsPersonalDto> {

    private final CarsMapper carsMapper;

    @Override
    public RentalsPersonal mapTo(RentalsPersonalDto object) {
        return RentalsPersonal.builder()
                .id(object.getId())
                .cars(carsMapper.mapTo(object.getCars()))
                .startDate(object.getStartDate())
                .endDate(object.getEndDate())
                .rentalsStatus(object.getRentalsStatus())
                .build();
    }

    @Override
    public RentalsPersonalDto mapFrom(RentalsPersonal object) {
        return RentalsPersonalDto.builder()
                .id(object.getId())
                .cars(carsMapper.mapFrom(object.getCars()))
                .startDate(object.getStartDate())
                .endDate(object.getEndDate())
                .rentalsStatus(object.getRentalsStatus())
                .build();
    }
}
