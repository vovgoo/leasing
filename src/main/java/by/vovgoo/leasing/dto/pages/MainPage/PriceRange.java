package by.vovgoo.leasing.dto.pages.MainPage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceRange {

    private Double lowerBound;

    private Double upperBound;
}

