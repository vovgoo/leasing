package by.vovgoo.leasing.dto;

import lombok.ToString;
import lombok.Value;
import org.springframework.data.domain.Page;

import java.util.List;

@Value
@ToString
public class PageResponse<T> {
    List<T> content;
    Metadata metadata;

    public static <T> PageResponse<T> of(Page<T> page) {
        Metadata metadata = new Metadata(page.getNumber(), page.getSize(), page.getTotalElements());
        return new PageResponse<>(page.getContent(), metadata);
    }

    @Value
    @ToString
    public static class Metadata {
        int page;
        int size;
        long totalElements;
    }
}
