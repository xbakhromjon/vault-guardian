package uz.bakhromjon.app.application;

import lombok.RequiredArgsConstructor;
import uz.bakhromjon.app.application.application.port.out.LoadApplicationPort;
import uz.bakhromjon.app.application.application.port.out.SaveApplicationPort;
import uz.bakhromjon.app.application.domain.Application;
import uz.bakhromjon.app.common.ErrorDataKey;
import uz.bakhromjon.app.common.ErrorMessage;
import uz.bakhromjon.app.common.PersistenceAdapter;
import uz.bakhromjon.app.common.DataNotFoundException;

import java.util.HashMap;
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
            HashMap<String, Long> data = new HashMap<>();
            data.put(ErrorDataKey.APPLICATION_ID, applicationId);
            throw new DataNotFoundException(ErrorMessage.APPLICATION_NOT_FOUND, data);
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
