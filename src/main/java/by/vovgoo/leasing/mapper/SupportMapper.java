package by.vovgoo.leasing.mapper;

import by.vovgoo.leasing.dto.SupportDto;
import by.vovgoo.leasing.entity.Support;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SupportMapper implements Mapper<Support, SupportDto> {

    private final UserMapper userMapper;

    @Override
    public Support mapTo(SupportDto object) {
        return Support.builder()
                .id(object.getId())
                .user(userMapper.mapTo(object.getUser()))
                .subject(object.getSubject())
                .createdAt(object.getCreatedAt())
                .updatedAt(object.getUpdatedAt())
                .build();
    }

    @Override
    public SupportDto mapFrom(Support object) {
        return SupportDto.builder()
                .id(object.getId())
                .user(userMapper.mapFrom(object.getUser()))
                .subject(object.getSubject())
                .createdAt(object.getCreatedAt())
                .updatedAt(object.getUpdatedAt())
                .build();
    }
}
