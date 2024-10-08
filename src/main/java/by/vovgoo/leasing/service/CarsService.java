package by.vovgoo.leasing.service;

import by.vovgoo.leasing.dto.pages.CarInfoPage.CarsInfoPage;
import by.vovgoo.leasing.dto.pages.MainPage.MainPageDto;
import by.vovgoo.leasing.dto.pages.SearchPage.SearchPageDto;
import by.vovgoo.leasing.entity.filters.CarsFilter;


public interface CarsService {

    CarsInfoPage getCarsInfoPage(Long id);

    MainPageDto getMainPage();

    SearchPageDto getSearchPage();
}
