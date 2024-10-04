package by.vovgoo.leasing.controllers;

import by.vovgoo.leasing.dto.*;
import by.vovgoo.leasing.entity.filters.UserFilter;
import by.vovgoo.leasing.service.SupportService;
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

    private final SupportService supportService;

    @GetMapping()
    public PageResponse<UserDto> getAllUsers(UserFilter userFilter, Pageable pageable) {
        return PageResponse.of(userService.findAll(userFilter, pageable));
    }

    @GetMapping("/personal")
    public ResponseEntity<UserPersonal> getUserPersonal() {
        UserPersonal userPersonal = userService.getUserPersonal();
        return ResponseEntity.ok(userPersonal);
    }

    @GetMapping("/personalRentals")
    public PageResponse<RentalsPersonalDto> getRentalsPersonal(@PathParam("id") Long id) {
        return userService.getRentalsPersonal(id);
    }

    @GetMapping("/order")
    public OrderPersonalDto getOrderPersonal(@PathParam("id") Long id) {
        return userService.getOrderPersonal(id);
    }

    @PostMapping("/support")
    public SupportDto sendSupport(@RequestBody SupportRequest supportRequest) {
        return supportService.create(supportRequest);
    }
}
