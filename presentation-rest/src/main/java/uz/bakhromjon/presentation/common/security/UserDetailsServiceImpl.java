package uz.bakhromjon.presentation.common.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.bakhromjon.application.common.SessionUser;
import uz.bakhromjon.application.common.SessionUserService;
import uz.bakhromjon.application.user.application.port.out.LoadUserPort;
import uz.bakhromjon.application.user.domain.User;

import java.util.Objects;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 31/10/22, Mon, 21:48
 **/
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService, SessionUserService {

    private final LoadUserPort loadUserPort;

    @Override
    public UserDetailsImpl loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = null;
        try {
            user = loadUserPort.loadByEmail(email);
        } catch (BadCredentialsException e) {
            throw new UsernameNotFoundException("User Not Found with email: " + email);
        }

        return UserDetailsImpl.build(user);
    }

    @Override
    public SessionUser getSession() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (authentication != null && !(authentication.getPrincipal() instanceof String)) ? (SessionUser) authentication.getPrincipal() : null;
    }

    @Override
    public User.UserId getSessionId() {
        SessionUser session = getSession();
        return Objects.isNull(session) ? new User.UserId(-1L) : session.getId();
    }
}


