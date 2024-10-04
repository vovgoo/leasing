package by.vovgoo.leasing.mapper;

import by.vovgoo.leasing.dto.CarsDto;
import by.vovgoo.leasing.entity.Cars;
import org.springframework.stereotype.Component;

@Component
public class CarsMapper implements Mapper<Cars, CarsDto> {

    @Override
    public Cars mapTo(CarsDto object) {
        return Cars.builder()
                .id(object.getId())
                .make(object.getMake())
                .model(object.getModel())
                .year(object.getYear())
                .color(object.getColor())
                .mileage(object.getMileage())
                .price(object.getPrice())
                .carStatus(object.getCarStatus())
                .description(object.getDescription())
                .image(object.getImage())
                .build();
    }

    @Override
    public CarsDto mapFrom(Cars object) {
        return CarsDto.builder()
                .id(object.getId())
                .make(object.getMake())
                .model(object.getModel())
                .year(object.getYear())
                .color(object.getColor())
                .mileage(object.getMileage())
                .price(object.getPrice())
                .carStatus(object.getCarStatus())
                .description(object.getDescription())
                .image(object.getImage())
                .build();
    }
}
