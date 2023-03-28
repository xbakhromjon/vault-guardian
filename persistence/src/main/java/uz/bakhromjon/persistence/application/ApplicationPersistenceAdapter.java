package uz.bakhromjon.persistence.application;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.application.application.application.port.out.LoadApplicationPort;
import uz.bakhromjon.application.application.application.port.out.SaveApplicationPort;
import uz.bakhromjon.application.application.domain.Application;
import uz.bakhromjon.common.ErrorData;
import uz.bakhromjon.persistence.common.PersistenceErrorDataKey;
import uz.bakhromjon.persistence.common.PersistenceErrorMessage;
import uz.bakhromjon.common.PersistenceAdapter;
import uz.bakhromjon.persistence.common.DataNotFoundException;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class ApplicationPersistenceAdapter implements LoadApplicationPort, SaveApplicationPort {
    private final ApplicationRepository applicationRepository;
    private final ApplicationPersistenceMapper APPLICATION_PERSISTENCE_MAPPER = ApplicationPersistenceMapper.INSTANCE;

    @Override
    public Application loadById(Long applicationId) {
        Optional<ApplicationJpaEntity> applicationOptional = applicationRepository.findById(applicationId);
        applicationOptional.orElseThrow(() -> {
            throw new DataNotFoundException(PersistenceErrorMessage.APPLICATION_NOT_FOUND, new ErrorData(PersistenceErrorDataKey.APPLICATION_ID, applicationId));
        });
        return APPLICATION_PERSISTENCE_MAPPER.mapToModel(applicationOptional.get());
    }

    @Override
    public Application save(Application application) {
        ApplicationJpaEntity entity = APPLICATION_PERSISTENCE_MAPPER.mapToEntity(application);
        entity = applicationRepository.save(entity);
        return APPLICATION_PERSISTENCE_MAPPER.mapToModel(entity);
    }
}
