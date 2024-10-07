package by.vovgoo.leasing.service.impl;

import by.vovgoo.leasing.dto.*;
import by.vovgoo.leasing.dto.pages.UserPersonalPage.UserPersonalPageDto;
import by.vovgoo.leasing.entity.User;
import by.vovgoo.leasing.entity.filters.QPredicates;
import by.vovgoo.leasing.entity.filters.UserFilter;
import by.vovgoo.leasing.mapper.UserMapper;
import by.vovgoo.leasing.repositories.UserRepository;
import by.vovgoo.leasing.service.RentalsService;
import by.vovgoo.leasing.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static by.vovgoo.leasing.entity.QUser.user;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final RentalsService rentalsService;

    public Optional<UserDto> findById(Long id) {
        return userRepository.findById(id).map(userMapper::mapFrom);
    }

    public Page<UserDto> findAll(UserFilter filter, Pageable pageable) {
        var predicate = QPredicates.builder()
                .add(filter.username(), user.username::containsIgnoreCase)
                .add(filter.email(), user.email::containsIgnoreCase)
                .add(filter.firstname(), user.firstName::containsIgnoreCase)
                .add(filter.lastname(), user.lastName::containsIgnoreCase)
                .add(filter.phoneNumber(), user.phoneNumber::containsIgnoreCase)
                .add(filter.address(), user.address::containsIgnoreCase)
                .build();

        return userRepository.findAll(predicate, PageRequest.of(pageable.getPageNumber(), 20)).map(userMapper::mapFrom);
    }

    @Transactional
    public UserDto update(Long id, UserDto userDto) {
        return Optional.of(userDto).map(userMapper::mapTo).map(userRepository::saveAndFlush).map(userMapper::mapFrom).orElseThrow();
    }

    @Transactional
    public boolean delete(Long id) {
        return userRepository.findById(id).map(entity -> {userRepository.delete(entity); userRepository.flush(); return true;}).orElse(false);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
            }
        };
    }

    @Override
    public UserPersonalPageDto getUserPersonal() {
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            return UserPersonalPageDto.builder()
                    .image(user.getImage())
                    .username(user.getUsername())
                    .lastName(user.getLastName())
                    .firstName(user.getFirstName())
                    .phoneNumber(user.getPhoneNumber())
                    .email(user.getEmail())
                    .address(user.getAddress())
                    .rentalsList(rentalsService.getUserRentals(0L))
                    .build();
        } catch(UsernameNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
