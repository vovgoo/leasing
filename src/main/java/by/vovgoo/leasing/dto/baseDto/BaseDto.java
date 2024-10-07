package by.vovgoo.leasing.dto.baseDto;

import java.io.Serializable;

public interface BaseDto <T extends Serializable> {
    T getId();

    void setId(T id);
}
