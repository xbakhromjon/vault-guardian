package uz.bakhromjon.presentation.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import uz.bakhromjon.application.auth.application.port.in.SignUpUseCase;
import uz.bakhromjon.application.auth.application.service.EmailAlreadyTakenException;
import uz.bakhromjon.application.token.application.port.in.response.AccessTokenResponse;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final SignUpUseCase signUpUseCase;


    @MutationMapping
    public AccessTokenResponse signup(@Argument String email, @Argument String masterPassword, @Argument String hint) throws EmailAlreadyTakenException {
        return signUpUseCase.signup(new SignUpUseCase.SignupRequest(email, masterPassword, hint));
    }
}
