package by.vovgoo.leasing.dto.pages.CarInfoPage;

import by.vovgoo.leasing.dto.CarsDto;
import by.vovgoo.leasing.dto.pages.utils.PageResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarsInfoPage {

    private CarsDto cars;

    @Builder.Default
    private PageResponse<CarInfoPageMaintenanceDto> maintenance = new PageResponse<>(Collections.emptyList(), new PageResponse.Metadata(0, 10, 0));
}
