package by.vovgoo.leasing.dto.baseDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class EditableDto <T extends Serializable> implements BaseDto<T> {

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
