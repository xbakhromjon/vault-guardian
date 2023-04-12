package uz.bakhromjon.presentation.common;


import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import uz.bakhromjon.application.common.SessionUser;
import uz.bakhromjon.application.common.SessionUserService;
import uz.bakhromjon.common.ErrorData;

@Component
@RequiredArgsConstructor
@Aspect
public class CheckRoleAspect {
    private final SessionUserService sessionUserService;

    @Before(value = "@annotation(checkRole)")
    public void checkRole(CheckRole checkRole) {
        SessionUser session = sessionUserService.getSession();
        if (!session.getRole().equals(checkRole.role())) {
            throw new AccessDeniedException(ErrorMessage.ACCESS_DENIED, new ErrorData(ErrorDataKey.ACCESSED_ROLE, checkRole.role()));
        }
    }
}
