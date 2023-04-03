package uz.bakhromjon.persistence.password;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.password.application.port.out.SavePasswordPort;
import uz.bakhromjon.application.password.domain.Password;
import uz.bakhromjon.common.PersistenceAdapter;

@PersistenceAdapter
@RequiredArgsConstructor
public class PasswordPersistenceAdapter implements SavePasswordPort {
    private final PasswordRepository passwordRepository;
    private final PasswordPersistenceMapper PASSWORD_PERSISTENCE_MAPPER = PasswordPersistenceMapper.INSTANCE;

    @Override
    public Password save(Password password) {
        PasswordJpaEntity entity = PASSWORD_PERSISTENCE_MAPPER.mapToEntity(password);
        entity = passwordRepository.save(entity);
        return PASSWORD_PERSISTENCE_MAPPER.mapToModel(entity);
    }
}
