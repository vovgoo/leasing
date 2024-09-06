package by.vovgoo.leasing.entity.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    MODERATOR,
    USER,
    MECHANIC;


    @Override
    public String getAuthority() {
        return name();
    }
}
