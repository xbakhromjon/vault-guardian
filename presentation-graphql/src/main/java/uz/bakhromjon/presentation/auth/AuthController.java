package uz.bakhromjon.presentation.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import uz.bakhromjon.application.auth.application.port.in.SignInUseCase;
import uz.bakhromjon.application.auth.application.port.in.SignUpUseCase;
import uz.bakhromjon.application.auth.application.service.BadCredentialsException;
import uz.bakhromjon.application.auth.application.service.EmailAlreadyTakenException;
import uz.bakhromjon.application.token.application.port.in.response.AccessTokenResponse;
import uz.bakhromjon.presentation.common.ErrorResponse;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final SignUpUseCase signUpUseCase;
    private final SignInUseCase signInUseCase;

    @MutationMapping
    public Object signup(@Argument @Valid SignUpUseCase.SignupRequest request) throws EmailAlreadyTakenException {
        try {
            return signUpUseCase.signup(request);
        } catch (EmailAlreadyTakenException e) {
            return new ErrorResponse(e.getMessage(), e.getLocalizedMessage(), e.getCode());
        } catch (Exception e) {
            return new ErrorResponse(e.getMessage(), e.getLocalizedMessage());
        }
    }

    @MutationMapping
    public Object signIn(@Argument @Valid SignInUseCase.SignInRequest request) {
        try {
            return signInUseCase.signIn(request);
        } catch (BadCredentialsException e) {
            return new ErrorResponse(e.getMessage(), e.getLocalizedMessage(), e.getCode());
        } catch (Exception e) {
            return new ErrorResponse(e.getMessage(), e.getLocalizedMessage());
        }
    }
}
