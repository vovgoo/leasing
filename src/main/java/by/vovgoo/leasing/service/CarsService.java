package by.vovgoo.leasing.service;

import by.vovgoo.leasing.dto.pages.CarInfoPage.CarsInfoPage;
import by.vovgoo.leasing.dto.pages.MainPage.MainPageDto;


public interface CarsService {

    CarsInfoPage getCarsInfoPage(Long id);

    MainPageDto getMainPage();
}
