package uz.bakhromjon.application.auth.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.auth.application.port.in.SignOutUseCase;
import uz.bakhromjon.application.token.application.port.out.DeleteAccessTokenOutPort;
import uz.bakhromjon.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class SignOutService implements SignOutUseCase {
    private final DeleteAccessTokenOutPort deleteAccessTokenOutPort;

    @Override
    public Void signOut(String token) {
        deleteAccessTokenOutPort.delete(token);
        return null;
    }
}
