package uz.bakhromjon.application.password.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.password.application.port.in.CreatePasswordUseCase;
import uz.bakhromjon.application.password.application.port.in.response.PasswordResponse;
import uz.bakhromjon.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class CreatePasswordService implements CreatePasswordUseCase {
    @Override
    public PasswordResponse create(PasswordCreateRequest createRequest) {
        return null;
    }
}
