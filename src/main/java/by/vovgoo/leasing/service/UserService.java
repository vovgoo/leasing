package by.vovgoo.leasing.service;

import by.vovgoo.leasing.dto.*;
import by.vovgoo.leasing.entity.filters.UserFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService {

    Optional<UserDto> findById(Long id);

    Page<UserDto> findAll(UserFilter filter, Pageable pageable);

//    UserDto create(UserDto userDto);

    UserDto update(Long id, UserDto userDto);

    boolean delete(Long id);

    UserDetailsService userDetailsService();

    UserPersonal getUserPersonal();

    PageResponse<RentalsPersonalDto> getRentalsPersonal(Long pageNumber);

    OrderPersonalDto getOrderPersonal(Long id);
}
