package by.vovgoo.leasing.dto;

import by.vovgoo.leasing.entity.RentalsPersonal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPersonal {

    private String image;

    private String username;

    private String lastName;

    private String firstName;

    private String phoneNumber;

    private String email;

    private String address;

    @Builder.Default
    PageResponse<RentalsPersonalDto> rentalsList = new PageResponse<>(Collections.emptyList(), new PageResponse.Metadata(0, 10, 0));;
}
