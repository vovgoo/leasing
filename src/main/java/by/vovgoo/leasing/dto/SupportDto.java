package by.vovgoo.leasing.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupportDto {

    private Long id;

    private UserDto user;

    private String subject;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;
}
