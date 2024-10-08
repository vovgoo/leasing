package by.vovgoo.leasing.service.impl;

import by.vovgoo.leasing.dto.pages.CarInfoPage.CarsInfoPage;
import by.vovgoo.leasing.dto.pages.MainPage.CarsBounds;
import by.vovgoo.leasing.dto.pages.MainPage.MainPageDto;
import by.vovgoo.leasing.dto.pages.MainPage.PriceRange;
import by.vovgoo.leasing.dto.pages.SearchPage.SearchPageDto;
import by.vovgoo.leasing.dto.pages.utils.PageResponse;
import by.vovgoo.leasing.entity.enums.CarStatus;
import by.vovgoo.leasing.mapper.CarsMapper;
import by.vovgoo.leasing.repositories.CarsRepository;
import by.vovgoo.leasing.service.CarsService;
import by.vovgoo.leasing.service.MaintenanceService;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CarsServiceImpl implements CarsService {

    private final CarsRepository carsRepository;

    private final MaintenanceService maintenanceService;

    private final CarsMapper carsMapper;

    @Override
    public CarsInfoPage getCarsInfoPage(Long id) {
        return CarsInfoPage.builder()
                .cars(carsRepository.findById(id).map(carsMapper::mapFrom).orElseThrow())
                .maintenance(maintenanceService.getCarMaintenanceByCarId(id, 0L))
                .build();
    }

    @Override
    public MainPageDto getMainPage() {

        List<Tuple> priceRanges = carsRepository.getCarsBounds();

        PriceRange lowPriceRange = null;
        PriceRange mediumPriceRange = null;
        PriceRange highPriceRange = null;

        for (Tuple tuple : priceRanges) {
            Double minPrice = tuple.get(1, Double.class);
            Double maxPrice = tuple.get(0, Double.class);
            String priceGroup = tuple.get(2, String.class);

            PriceRange currentRange = new PriceRange(minPrice, maxPrice);

            switch (priceGroup) {
                case "low":
                    lowPriceRange = currentRange;
                    break;
                case "middle":
                    mediumPriceRange = currentRange;
                    break;
                case "high":
                    highPriceRange = currentRange;
                    break;
            }
        }

        return MainPageDto.builder()
                .cars(carsRepository.getMostPopularCars().stream()
                        .map(carsMapper::mapFrom)
                        .toList())
                .carsBounds(CarsBounds.builder()
                        .lowPriceRange(lowPriceRange != null ? lowPriceRange : new PriceRange(0D, 0D))
                        .mediumPriceRange(mediumPriceRange != null ? mediumPriceRange : new PriceRange(0D, 0D))
                        .highPriceRange(highPriceRange != null ? highPriceRange : new PriceRange(0D, 0D))
                        .build())
                .build();
    }

    @Override
    public SearchPageDto getSearchPage() {

        List<Tuple> criteriaData = carsRepository.getCarsCriteria();

        List<String> make = new ArrayList<>();
        List<Integer> year = new ArrayList<>();
        List<String> color = new ArrayList<>();
        List<CarStatus> carStatuses = new ArrayList<>();
        Integer priceUpper = 0;
        Integer priceDown = 0;


        for (Tuple tuple : criteriaData) {
            String category = tuple.get(0, String.class);
            String value = tuple.get(1, String.class);

            switch (category) {
                case "make":
                    if (value != null) {
                        make.add(value);
                    }
                    break;
                case "year":
                    if (value != null) {
                        try {
                            year.add(Integer.parseInt(value));
                        } catch (NumberFormatException ex) {
                            throw new NumberFormatException();
                        }
                    }
                   break;
                case "color":
                    if (value != null) {
                        color.add(value);
                    }
                    break;
                case "car_status":
                    if (value != null) {
                        try {
                            carStatuses.add(CarStatus.valueOf(value));
                        } catch (IllegalArgumentException e) {
                            throw new IllegalArgumentException();
                        }
                    }
                    break;
                case "priceDown":
                    if (value != null) {
                        try {
                            priceDown = Integer.parseInt(value);
                        } catch (NumberFormatException e) {
                            throw new NumberFormatException();
                        }
                    }
                    break;
                case "priceUpper":
                    if (value != null) {
                        try {
                            priceUpper = Integer.parseInt(value);
                        } catch (NumberFormatException e) {
                            throw new NumberFormatException();
                        }
                    }
                    break;
            }
        }

        SearchPageDto.Criteria criteria = SearchPageDto.Criteria.builder()
                .make(make)
                .year(year)
                .color(color)
                .priceDown(priceDown)
                .priceUpper(priceUpper)
                .carStatuses(carStatuses)
                .build();

        return SearchPageDto.builder()
                .criteria(criteria)
                .cars(PageResponse.of(carsRepository.findAll(PageRequest.of(0, 12)).map(carsMapper::mapFrom)))
                .build();
    }

}
