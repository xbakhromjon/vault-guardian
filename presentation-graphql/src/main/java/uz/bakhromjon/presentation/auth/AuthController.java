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

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final SignUpUseCase signUpUseCase;
    private final SignInUseCase signInUseCase;

    @MutationMapping
    public AccessTokenResponse signup(@Argument @Valid SignUpUseCase.SignupRequest request) throws EmailAlreadyTakenException {
        return signUpUseCase.signup(request);
    }

    @MutationMapping
    public AccessTokenResponse signIn(@Argument @Valid SignInUseCase.SignInRequest request) throws BadCredentialsException {
        return signInUseCase.signIn(request);
    }
}
