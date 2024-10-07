package by.vovgoo.leasing.service;

import by.vovgoo.leasing.dto.SupportDto;
import by.vovgoo.leasing.dto.pages.SupportPage.SupportRequest;

public interface SupportService {

    SupportDto create(SupportRequest supportRequest);
}
