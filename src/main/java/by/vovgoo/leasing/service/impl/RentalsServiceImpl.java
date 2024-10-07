package by.vovgoo.leasing.service.impl;

import by.vovgoo.leasing.dto.pages.UserPersonalPage.UserPersonalPageRentalsDto;
import by.vovgoo.leasing.dto.pages.utils.PageResponse;
import by.vovgoo.leasing.entity.Rentals;
import by.vovgoo.leasing.entity.User;
import by.vovgoo.leasing.mapper.CarsMapper;
import by.vovgoo.leasing.repositories.RentalsRepository;
import by.vovgoo.leasing.service.RentalsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalsServiceImpl implements RentalsService {

    private final RentalsRepository rentalsRepository;

    private final UserPersonalPageRentalsMapper userPersonalPageRentalsMapper;

    @RequiredArgsConstructor
    @Component
    public static class UserPersonalPageRentalsMapper {

        private final CarsMapper carsMapper;

        public UserPersonalPageRentalsDto map(Rentals obj) {
            return UserPersonalPageRentalsDto.builder()
                    .id(obj.getId())
                    .cars(carsMapper.mapFrom(obj.getCars()))
                    .startDate(obj.getStartDate())
                    .endDate(obj.getEndDate())
                    .rentalsStatus(obj.getRentalsStatus())
                    .build();
        }
    }

    @Override
    public PageResponse<UserPersonalPageRentalsDto> getUserRentals(Long pageNumber) {
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            Page<UserPersonalPageRentalsDto> rentalsList = rentalsRepository.findAllPersonalRentalsByUserId(user.getId(), PageRequest.of(Math.toIntExact(pageNumber), 10)).map(userPersonalPageRentalsMapper::map);

            return PageResponse.of(rentalsList);
        } catch(UsernameNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());
        }
    }
}
