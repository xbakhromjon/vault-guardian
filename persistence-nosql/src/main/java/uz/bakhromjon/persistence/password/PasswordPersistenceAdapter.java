package uz.bakhromjon.persistence.password;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.common.PageableResponse;
import uz.bakhromjon.application.password.application.port.in.PasswordSearchCriteria;
import uz.bakhromjon.application.password.application.port.out.DeletePasswordPort;
import uz.bakhromjon.application.password.application.port.out.LoadPasswordPort;
import uz.bakhromjon.application.password.application.port.out.SavePasswordPort;
import uz.bakhromjon.application.password.domain.Password;
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
public class PasswordPersistenceAdapter implements SavePasswordPort, LoadPasswordPort, DeletePasswordPort {
    private final PasswordRepository passwordRepository;
    private final PasswordPersistenceMapper PASSWORD_PERSISTENCE_MAPPER = PasswordPersistenceMapper.INSTANCE;
    private final LoadUserPort loadUserPort;

    @Override
    public Password save(Password password) {
        if (!loadUserPort.existsById(password.getOwnerId())) {
            throw new DataNotFoundException(PersistenceErrorMessage.USER_NOT_FOUND, new ErrorData(PersistenceErrorDataKey.USER_ID, password.getOwnerId()));
        }
        PasswordDocument entity = PASSWORD_PERSISTENCE_MAPPER.mapToEntity(password);
        entity = passwordRepository.save(entity);
        return PASSWORD_PERSISTENCE_MAPPER.mapToModel(entity);
    }

    @Override
    public Password load(Password.PasswordId id, User.UserId requestedUserId) {
        Optional<PasswordDocument> passwordOptional = passwordRepository.findByIdAndOwnerId(id.getValue(), requestedUserId.getValue());
        PasswordDocument entity = passwordOptional.orElseThrow(() -> {
            throw new DataNotFoundException(PersistenceErrorMessage.PASSWORD_NOT_FOUND, new ErrorData(PersistenceErrorDataKey.PASSWORD_ID, id.getValue()));
        });
        return PASSWORD_PERSISTENCE_MAPPER.mapToModel(entity);
    }

    @Override
    public Password loadForUpdate(Password.PasswordId id, User.UserId requestedUserId) {
        Optional<PasswordDocument> passwordOptional = passwordRepository.findByIdAndOwnerId(id.getValue(), requestedUserId.getValue());
        PasswordDocument entity = passwordOptional.orElseThrow(() -> {
            throw new DataNotFoundException(PersistenceErrorMessage.PASSWORD_NOT_FOUND, new ErrorData(PersistenceErrorDataKey.PASSWORD_ID, id.getValue()));
        });
        return PASSWORD_PERSISTENCE_MAPPER.mapToModel(entity);
    }

    @Override
    public boolean deleteById(Password.PasswordId id) {
        if (!passwordRepository.existsById(id.getValue())) {
            return false;
        }
        passwordRepository.deleteById(id.getValue());
        return true;
    }


    @Override
    public PageableResponse<Password> search(PasswordSearchCriteria criteria) {
        return null;
    }
}
