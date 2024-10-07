package by.vovgoo.leasing.controllers;

import by.vovgoo.leasing.dto.SupportDto;
import by.vovgoo.leasing.dto.pages.SupportPage.SupportRequest;
import by.vovgoo.leasing.service.SupportService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/support")
public class SupportController {

    private final SupportService supportService;

    @PostMapping
    public SupportDto sendSupport(@RequestBody SupportRequest supportRequest) {
        return supportService.create(supportRequest);
    }

}
