package uz.bakhromjon.application.passport.application.service;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.passport.application.port.in.DeletePassportUseCase;
import uz.bakhromjon.application.passport.application.port.out.DeletePassportPort;
import uz.bakhromjon.application.passport.domain.Passport;
import uz.bakhromjon.application.password.application.port.in.DeletePasswordUseCase;
import uz.bakhromjon.application.password.application.port.out.DeletePasswordPort;
import uz.bakhromjon.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class DeletePassportService implements DeletePassportUseCase {
    private final DeletePassportPort deletePassportPort;

    @Override
    public boolean delete(Passport.PassportId id) {
        return deletePassportPort.deleteById(id);
    }
}
