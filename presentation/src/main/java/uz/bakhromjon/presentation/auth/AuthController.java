package uz.bakhromjon.presentation.auth;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uz.bakhromjon.application.auth.application.port.in.SignInUseCase;
import uz.bakhromjon.application.auth.application.port.in.SignOutUseCase;
import uz.bakhromjon.application.auth.application.port.in.SignUpUseCase;
import uz.bakhromjon.application.auth.application.service.BadCredentialsException;
import uz.bakhromjon.application.auth.application.service.EmailAlreadyTakenException;
import uz.bakhromjon.application.token.application.port.in.response.AccessTokenResponse;
import uz.bakhromjon.common.WebAdapter;
import uz.bakhromjon.presentation.common.GenericResponse;

@WebAdapter
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Validated
public class AuthController {
    private final SignUpUseCase signupUseCase;
    private final SignInUseCase signInUseCase;
    private final SignOutUseCase signOutUseCase;


    @PostMapping("/signup")
    public GenericResponse<AccessTokenResponse> signup(@RequestBody @Valid SignUpUseCase.SignupRequest signupRequest) throws EmailAlreadyTakenException {
        return GenericResponse.ok(signupUseCase.signup(signupRequest));
    }

    @PostMapping("/signIn")
    public GenericResponse<AccessTokenResponse> signIn(@RequestBody @Valid SignInUseCase.SignInRequest signInRequest) throws BadCredentialsException {
        return GenericResponse.ok(signInUseCase.signIn(signInRequest));
    }

    @DeleteMapping("/signOut")
    public GenericResponse<Void> signup(@RequestParam @NotBlank String token) {
        return GenericResponse.ok(signOutUseCase.signOut(token));
    }
}
