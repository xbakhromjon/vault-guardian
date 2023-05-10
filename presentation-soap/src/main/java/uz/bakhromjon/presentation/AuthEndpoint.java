package uz.bakhromjon.presentation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import uz.bakhromjon.application.auth.application.port.in.SignInUseCase;
import uz.bakhromjon.application.auth.application.port.in.SignUpUseCase;
import uz.bakhromjon.application.auth.application.service.EmailAlreadyTakenException;
import uz.bakhromjon.application.token.application.port.in.response.AccessTokenResponse;

@Endpoint
@RequiredArgsConstructor
public class AuthEndpoint {
    private final SignUpUseCase signUpUseCase;
    private final SignInUseCase signInUseCase;
    private static final String NAMESPACE_URI = "http://www.howtodoinjava.com/xml/school";


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
    @ResponsePayload
    public AccessTokenResponse signup(@RequestPayload @Valid SignUpUseCase.SignupRequest signupRequest) throws EmailAlreadyTakenException {
        return signUpUseCase.signup(signupRequest);
    }


}




