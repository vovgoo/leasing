package by.vovgoo.leasing.dto.pages.MainPage;

import by.vovgoo.leasing.dto.CarsDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MainPageDto {

    @Builder.Default
    List<CarsDto> cars = new ArrayList<>();

    private CarsBounds carsBounds;
}
