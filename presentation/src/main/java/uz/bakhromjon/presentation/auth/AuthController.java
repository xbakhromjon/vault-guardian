package uz.bakhromjon.presentation.auth;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bakhromjon.application.auth.application.port.in.SignInUseCase;
import uz.bakhromjon.application.auth.application.port.in.SignUpUseCase;
import uz.bakhromjon.application.auth.application.service.EmailAlreadyTakenException;
import uz.bakhromjon.application.token.application.port.in.response.AccessTokenResponse;
import uz.bakhromjon.common.WebAdapter;
import uz.bakhromjon.presentation.common.GenericResponse;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final SignUpUseCase signupService;
    private final SignInUseCase signInUseCase;


    @PostMapping("/signup")
    public GenericResponse<AccessTokenResponse> signup(@RequestBody @Valid SignUpUseCase.SignupRequest signupRequest) throws EmailAlreadyTakenException {
        return GenericResponse.ok(signupService.signup(signupRequest));
    }

    @PostMapping("/signIn")
    public GenericResponse<AccessTokenResponse> signup(@RequestBody @Valid SignInUseCase.SignInRequest signInRequest){
        return GenericResponse.ok(signInUseCase.signIn(signInRequest));
    }


}
