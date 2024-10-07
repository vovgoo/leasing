package by.vovgoo.leasing.service;

import by.vovgoo.leasing.dto.*;
import by.vovgoo.leasing.dto.pages.UserPersonalPage.UserPersonalPageDto;
import by.vovgoo.leasing.entity.filters.UserFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService {

    Optional<UserDto> findById(Long id);

    Page<UserDto> findAll(UserFilter filter, Pageable pageable);

    UserDto update(Long id, UserDto userDto);

    boolean delete(Long id);

    UserDetailsService userDetailsService();

    UserPersonalPageDto getUserPersonal();
}
