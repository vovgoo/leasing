package by.vovgoo.leasing.entity.baseEntity;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class EditableEntity <T extends Serializable> implements BaseEntity<T> {

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
