package by.vovgoo.leasing.dto.pages.SearchPage;

import by.vovgoo.leasing.dto.CarsDto;
import by.vovgoo.leasing.dto.pages.utils.PageResponse;
import by.vovgoo.leasing.entity.enums.CarStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchPageDto {

    private Criteria criteria;

    private PageResponse<CarsDto> cars;

    @Component
    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Criteria {

        @Builder.Default
        private List<String> make = new ArrayList<>();

        @Builder.Default
        private List<Integer> year = new ArrayList<>();

        @Builder.Default
        private List<String> color = new ArrayList<>();

        private Integer priceDown;

        private Integer priceUpper;

        @Builder.Default
        private List<CarStatus> carStatuses = new ArrayList<>();
    }
}
