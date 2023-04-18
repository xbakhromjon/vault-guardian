package uz.bakhromjon.presentation.common.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.bakhromjon.application.common.SessionUser;
import uz.bakhromjon.application.user.domain.User;
import uz.bakhromjon.common.ERole;

import java.util.Collection;
import java.util.List;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 31/10/22, Mon, 21:46
 **/
@Getter
@AllArgsConstructor
public class UserDetailsImpl implements UserDetails, SessionUser {
    private User.UserId id;
    private String email;
    private String masterPassword;
    private String hint;
    private ERole role;

    public static UserDetailsImpl build(User user) {
        return new UserDetailsImpl(user.getId(), user.getEmail(), user.getMasterPassword(), user.getHint(), user.getRole());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of((GrantedAuthority) () -> role.name());
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
