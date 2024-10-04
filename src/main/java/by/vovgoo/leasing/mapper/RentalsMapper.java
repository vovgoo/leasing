package by.vovgoo.leasing.mapper;

import by.vovgoo.leasing.dto.RentalsDto;
import by.vovgoo.leasing.entity.Rentals;
import by.vovgoo.leasing.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RentalsMapper implements Mapper<Rentals, RentalsDto> {

    private final CarsMapper carsMapper;

    private final UserMapper userMapper;

    @Override
    public Rentals mapTo(RentalsDto object) {
        return Rentals.builder()
                .id(object.getId())
                .cars(carsMapper.mapTo(object.getCars()))
                .user(userMapper.mapTo(object.getUser()))
                .startDate(object.getStartDate())
                .endDate(object.getEndDate())
                .rentalsStatus(object.getRentalsStatus())
                .build();
    }

    @Override
    public RentalsDto mapFrom(Rentals object) {
        return RentalsDto.builder()
                .id(object.getId())
                .cars(carsMapper.mapFrom(object.getCars()))
                .user(userMapper.mapFrom(object.getUser()))
                .startDate(object.getStartDate())
                .endDate(object.getEndDate())
                .rentalsStatus(object.getRentalsStatus())
                .build();
    }
}
