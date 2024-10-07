package by.vovgoo.leasing.dto.pages.UserPersonalPage;

import by.vovgoo.leasing.dto.pages.utils.PageResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPersonalPageDto {

    private String image;

    private String username;

    private String lastName;

    private String firstName;

    private String phoneNumber;

    private String email;

    private String address;

    @Builder.Default
    PageResponse<UserPersonalPageRentalsDto> rentalsList = new PageResponse<>(Collections.emptyList(), new PageResponse.Metadata(0, 10, 0));
}
