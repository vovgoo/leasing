package by.vovgoo.leasing.service;

import by.vovgoo.leasing.dto.CarsDto;
import by.vovgoo.leasing.dto.pages.CarInfoPage.CarsInfoPage;
import by.vovgoo.leasing.dto.pages.MainPage.MainPageDto;
import by.vovgoo.leasing.dto.pages.SearchPage.SearchPageDto;
import by.vovgoo.leasing.dto.pages.utils.PageResponse;
import by.vovgoo.leasing.entity.filters.CarsFilter;
import org.springframework.data.domain.Pageable;


public interface CarsService {

    CarsInfoPage getCarsInfoPage(Long id);

    MainPageDto getMainPage();

    SearchPageDto getSearchPage();

    PageResponse<CarsDto> findAll(CarsFilter filter, Pageable pageable);
}
