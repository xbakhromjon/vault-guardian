package uz.bakhromjon.persistence.passport;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.common.PageableResponse;
import uz.bakhromjon.application.passport.application.port.in.PassportSearchCriteria;
import uz.bakhromjon.application.passport.application.port.out.DeletePassportPort;
import uz.bakhromjon.application.passport.application.port.out.LoadPassportPort;
import uz.bakhromjon.application.passport.application.port.out.SavePassportPort;
import uz.bakhromjon.application.passport.domain.Passport;
import uz.bakhromjon.application.user.application.port.out.LoadUserPort;
import uz.bakhromjon.application.user.domain.User;
import uz.bakhromjon.common.ErrorData;
import uz.bakhromjon.common.PersistenceAdapter;
import uz.bakhromjon.persistence.common.DataNotFoundException;
import uz.bakhromjon.persistence.common.PersistenceErrorDataKey;
import uz.bakhromjon.persistence.common.PersistenceErrorMessage;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class PassportPersistenceAdapter implements SavePassportPort, LoadPassportPort, DeletePassportPort {
    private final PassportRepository passportRepository;
    private final PassportPersistenceMapper PASSPORT_PERSISTENCE_MAPPER = PassportPersistenceMapper.INSTANCE;
    private final LoadUserPort loadUserPort;

    @Override
    public Passport save(Passport passport) {
        if (!loadUserPort.existsById(passport.getOwnerId())) {
            throw new DataNotFoundException(PersistenceErrorMessage.USER_NOT_FOUND, new ErrorData(PersistenceErrorDataKey.USER_ID, passport.getOwnerId()));
        }
        PassportDocument entity = PASSPORT_PERSISTENCE_MAPPER.mapToEntity(passport);
        entity = passportRepository.save(entity);
        return PASSPORT_PERSISTENCE_MAPPER.mapToModel(entity);
    }

    @Override
    public Passport load(Passport.PassportId passportId, User.UserId requestedUserId) {
        Optional<PassportDocument> passportOptional = passportRepository.findByIdAndOwnerId(passportId.getValue(), requestedUserId.getValue());
        PassportDocument entity = passportOptional.orElseThrow(() -> {
            throw new DataNotFoundException(PersistenceErrorMessage.PASSPORT_NOT_FOUND, new ErrorData(PersistenceErrorDataKey.PASSPORT_ID, passportId));
        });
        return PASSPORT_PERSISTENCE_MAPPER.mapToModel(entity);
    }

    @Override
    public Passport loadForUpdate(Passport.PassportId passportId, User.UserId requestedUserId) {
        Optional<PassportDocument> passportOptional = passportRepository.findByIdAndOwnerId(passportId.getValue(), requestedUserId.getValue());
        PassportDocument entity = passportOptional.orElseThrow(() -> {
            throw new DataNotFoundException(PersistenceErrorMessage.PASSPORT_NOT_FOUND, new ErrorData(PersistenceErrorDataKey.PASSPORT_ID, passportId));
        });
        return PASSPORT_PERSISTENCE_MAPPER.mapToModel(entity);
    }

    @Override
    public boolean deleteById(Passport.PassportId id) {
        if (!passportRepository.existsById(id.getValue())) {
            return false;
        }
        passportRepository.deleteById(id.getValue());
        return true;
    }

    @Override
    public PageableResponse<Passport> search(PassportSearchCriteria criteria) {
        return null;
    }

}
