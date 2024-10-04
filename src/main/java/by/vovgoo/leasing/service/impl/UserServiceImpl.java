package by.vovgoo.leasing.service.impl;

import by.vovgoo.leasing.dto.*;
import by.vovgoo.leasing.entity.OrderPersonal;
import by.vovgoo.leasing.entity.User;
import by.vovgoo.leasing.entity.filters.QPredicates;
import by.vovgoo.leasing.entity.filters.UserFilter;
import by.vovgoo.leasing.mapper.OrderPersonalMapper;
import by.vovgoo.leasing.mapper.RentalsPersonalMapper;
import by.vovgoo.leasing.mapper.UserMapper;
import by.vovgoo.leasing.repositories.PaymentsRepository;
import by.vovgoo.leasing.repositories.RentalsRepository;
import by.vovgoo.leasing.repositories.UserRepository;
import by.vovgoo.leasing.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
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

    private final RentalsRepository rentalsRepository;

    private final RentalsPersonalMapper rentalsPersonalMapper;

    private final PaymentsRepository paymentsRepository;

    private final OrderPersonalMapper orderPersonalMapper;

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

//    @Transactional
//    public UserDto create(UserDto userDto) {
//        User user = userMapper.mapTo(userDto);
//        user.setPasswordHash(passwordEncoder.encode(user.getPassword()));
//        return Optional.of(user).map(userRepository::save).map(userMapper::mapFrom).orElseThrow();
//    }

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
    public UserPersonal getUserPersonal() {
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            Page<RentalsPersonalDto> rentalsList = rentalsRepository.findAllPersonalRentalsByUserId(user.getId(), PageRequest.of(0, 10)).map(rentalsPersonalMapper::mapFrom);

            return UserPersonal.builder()
                    .image(user.getImage())
                    .username(user.getUsername())
                    .lastName(user.getLastName())
                    .firstName(user.getFirstName())
                    .phoneNumber(user.getPhoneNumber())
                    .email(user.getEmail())
                    .address(user.getAddress())
                    .rentalsList(PageResponse.of(rentalsList))
                    .build();
        } catch(UsernameNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }

    @Override
    public PageResponse<RentalsPersonalDto> getRentalsPersonal(Long pageNumber) {
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            Page<RentalsPersonalDto> rentalsList = rentalsRepository.findAllPersonalRentalsByUserId(user.getId(), PageRequest.of(Math.toIntExact(pageNumber), 10)).map(rentalsPersonalMapper::mapFrom);

            return PageResponse.of(rentalsList);
        } catch(UsernameNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }

    @Override
    public OrderPersonalDto getOrderPersonal(Long id) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        OrderPersonalDto orderPersonal = paymentsRepository.getOrderPersonalById(id).map(orderPersonalMapper::mapFrom).orElseThrow();

        if(!orderPersonal.getPayments().getUser().getId().equals(user.getId())) {
            throw new AccessDeniedException("You not have permissions");
        }

        return orderPersonal;
    }
}
