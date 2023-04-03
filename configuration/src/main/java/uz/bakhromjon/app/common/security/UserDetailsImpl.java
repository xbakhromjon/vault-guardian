package uz.bakhromjon.app.common.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.bakhromjon.application.common.SessionUser;
import uz.bakhromjon.application.user.domain.User;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 31/10/22, Mon, 21:46
 **/
@Getter
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails, SessionUser {
    private Long id;
    private String email;
    private String masterPassword;
    private String hint;

    public static UserDetailsImpl build(User user) {
        return new UserDetailsImpl(user.getId(), user. getEmail(), user.getMasterPassword(), user.getHint());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return masterPassword;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
