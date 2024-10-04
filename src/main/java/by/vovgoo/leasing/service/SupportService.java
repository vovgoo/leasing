package by.vovgoo.leasing.service;

import by.vovgoo.leasing.dto.SupportDto;
import by.vovgoo.leasing.dto.SupportRequest;

public interface SupportService {

    SupportDto create(SupportRequest supportRequest);
}
