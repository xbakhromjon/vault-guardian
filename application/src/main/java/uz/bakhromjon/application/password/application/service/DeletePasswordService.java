package uz.bakhromjon.application.password.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.password.application.port.in.DeletePasswordUseCase;
import uz.bakhromjon.application.password.application.port.out.DeletePasswordPort;
import uz.bakhromjon.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class DeletePasswordService implements DeletePasswordUseCase {
    private final DeletePasswordPort deletePasswordPort;

    @Override
    public void delete(long id) {
        deletePasswordPort.deleteById(id);
    }
}