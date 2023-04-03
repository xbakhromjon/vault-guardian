package uz.bakhromjon.persistence.password;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.password.application.port.out.DeletePasswordPort;
import uz.bakhromjon.application.password.application.port.out.LoadPasswordPort;
import uz.bakhromjon.application.password.application.port.out.SavePasswordPort;
import uz.bakhromjon.application.password.domain.Password;
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

    @Override
    public Password save(Password password) {
        PasswordJpaEntity entity = PASSWORD_PERSISTENCE_MAPPER.mapToEntity(password);
        entity = passwordRepository.save(entity);
        return PASSWORD_PERSISTENCE_MAPPER.mapToModel(entity);
    }

    @Override
    public Password load(long passwordId, long requestedUserId) {
        Optional<PasswordJpaEntity> passwordOptional = passwordRepository.findByIdAndOwnerId(passwordId, requestedUserId);
        PasswordJpaEntity entity = passwordOptional.orElseThrow(() -> {
            throw new DataNotFoundException(PersistenceErrorMessage.PASSWORD_NOT_FOUND, new ErrorData(PersistenceErrorDataKey.PASSWORD_ID, passwordId));
        });
        return PASSWORD_PERSISTENCE_MAPPER.mapToModel(entity);
    }

    @Override
    public void deleteById(long passwordId) {
        passwordRepository.deleteById(passwordId);
    }
}
