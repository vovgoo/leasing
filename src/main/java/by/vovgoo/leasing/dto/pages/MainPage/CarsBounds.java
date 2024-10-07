package by.vovgoo.leasing.dto.pages.MainPage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarsBounds {

    private PriceRange lowPriceRange;
    private PriceRange mediumPriceRange;
    private PriceRange highPriceRange;

}