package by.vovgoo.leasing.entity.filters;

import by.vovgoo.leasing.entity.enums.CarColor;
import by.vovgoo.leasing.entity.enums.CarStatus;

import java.util.List;

public record CarsFilter(String carName, List<String> make, List<Integer> year, List<CarColor> color, Double priceUpper, Double priceDown, List<CarStatus> carStatus) {

}
