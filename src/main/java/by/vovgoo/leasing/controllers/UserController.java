package by.vovgoo.leasing.controllers;

import by.vovgoo.leasing.dto.*;
import by.vovgoo.leasing.dto.pages.OrderPersonalPage.OrderPersonaPageDto;
import by.vovgoo.leasing.dto.pages.UserPersonalPage.UserPersonalPageRentalsDto;
import by.vovgoo.leasing.dto.pages.UserPersonalPage.UserPersonalPageDto;
import by.vovgoo.leasing.dto.pages.utils.PageResponse;
import by.vovgoo.leasing.entity.filters.UserFilter;
import by.vovgoo.leasing.service.UserService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping()
    public PageResponse<UserDto> getAllUsers(UserFilter userFilter, Pageable pageable) {
        return PageResponse.of(userService.findAll(userFilter, pageable));
    }

    @GetMapping("/personal")
    public ResponseEntity<UserPersonalPageDto> getUserPersonal() {
        return ResponseEntity.ok(userService.getUserPersonal());
    }

}
