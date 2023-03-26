package uz.bakhromjon.persistence.user;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.user.application.port.out.LoadUserPort;
import uz.bakhromjon.application.user.application.port.out.SaveUserPort;
import uz.bakhromjon.application.user.domain.User;
import uz.bakhromjon.common.PersistenceAdapter;
import uz.bakhromjon.persistence.common.DataNotFoundException;
import uz.bakhromjon.persistence.common.ErrorData;
import uz.bakhromjon.persistence.common.ErrorDataKey;
import uz.bakhromjon.persistence.common.ErrorMessage;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserPersistenceAdapter implements SaveUserPort, LoadUserPort {
    private final UserRepository userRepository;
    private final UserPersistenceMapper USER_PERSISTENCE_MAPPER = UserPersistenceMapper.INSTANCE;

    @Override
    public User save(User user) {
        UserJpaEntity entity = USER_PERSISTENCE_MAPPER.mapToEntity(user);
        entity = userRepository.save(entity);
        return USER_PERSISTENCE_MAPPER.mapToModel(entity);
    }

    @Override
    public User loadByEmail(String email) {
        Optional<UserJpaEntity> optional = userRepository.findByEmail(email);
        UserJpaEntity entity = optional.orElseThrow(() -> {
            throw new DataNotFoundException(ErrorMessage.USER_NOT_FOUND, new ErrorData(ErrorDataKey.USER_EMAIL, email));
        });
        return USER_PERSISTENCE_MAPPER.mapToModel(entity);
    }
}
