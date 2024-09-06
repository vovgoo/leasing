package by.vovgoo.leasing.entity.baseEntity;

import by.vovgoo.leasing.entity.baseEntity.BaseEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class EditableEntity <T extends Serializable> implements BaseEntity<T> {

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
