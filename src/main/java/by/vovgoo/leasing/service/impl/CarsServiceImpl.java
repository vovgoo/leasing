package by.vovgoo.leasing.service.impl;

import by.vovgoo.leasing.dto.pages.CarInfoPage.CarsInfoPage;
import by.vovgoo.leasing.dto.pages.MainPage.CarsBounds;
import by.vovgoo.leasing.dto.pages.MainPage.MainPageDto;
import by.vovgoo.leasing.dto.pages.MainPage.PriceRange;
import by.vovgoo.leasing.mapper.CarsMapper;
import by.vovgoo.leasing.repositories.CarsRepository;
import by.vovgoo.leasing.service.CarsService;
import by.vovgoo.leasing.service.MaintenanceService;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
