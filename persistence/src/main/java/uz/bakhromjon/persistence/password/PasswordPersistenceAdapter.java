package uz.bakhromjon.persistence.password;

import lombok.RequiredArgsConstructor;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.BooleanPredicateClausesStep;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.scope.SearchScope;
import org.hibernate.search.mapper.orm.session.SearchSession;
import uz.bakhromjon.application.common.PageableResponse;
import uz.bakhromjon.application.password.application.port.in.criteria.PasswordSearchCriteria;
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

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class PasswordPersistenceAdapter implements SavePasswordPort, LoadPasswordPort, DeletePasswordPort {
    private final PasswordRepository passwordRepository;
    private final PasswordPersistenceMapper PASSWORD_PERSISTENCE_MAPPER = PasswordPersistenceMapper.INSTANCE;
    private final SearchSession searchSession;
    private final LoadUserPort loadUserPort;

    @Override
    public Password save(Password password) {
        if (!loadUserPort.existsById(password.getOwnerId())) {
            throw new DataNotFoundException(PersistenceErrorMessage.USER_NOT_FOUND, new ErrorData(PersistenceErrorDataKey.USER_ID, password.getOwnerId()));
        }
        PasswordJpaEntity entity = PASSWORD_PERSISTENCE_MAPPER.mapToEntity(password);
        entity = passwordRepository.save(entity);
        return PASSWORD_PERSISTENCE_MAPPER.mapToModel(entity);
    }

    @Override
    public Password load(Password.PasswordId id, User.UserId requestedUserId) {
        Optional<PasswordJpaEntity> passwordOptional = passwordRepository.findByIdAndOwnerId(id.getValue(), requestedUserId.getValue());
        PasswordJpaEntity entity = passwordOptional.orElseThrow(() -> {
            throw new DataNotFoundException(PersistenceErrorMessage.PASSWORD_NOT_FOUND, new ErrorData(PersistenceErrorDataKey.PASSWORD_ID, id.getValue()));
        });
        return PASSWORD_PERSISTENCE_MAPPER.mapToModel(entity);
    }

    @Override
    public Password loadForUpdate(Password.PasswordId id, User.UserId requestedUserId) {
        Optional<PasswordJpaEntity> passwordOptional = passwordRepository.findByIdAndOwnerIdForUpdate(id.getValue(), requestedUserId.getValue());
        PasswordJpaEntity entity = passwordOptional.orElseThrow(() -> {
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
        SearchScope<PasswordJpaEntity> scope = searchSession.scope(PasswordJpaEntity.class);
        BooleanPredicateClausesStep<?> bool = scope.predicate().bool();

        if (Objects.nonNull(criteria.getSearch()) && !criteria.getSearch().isBlank()) {
            bool.must(scope.predicate().match().fields("name", "username", "notes").matching(criteria.getSearch()));
        }

        int offset = criteria.getPage() * criteria.getSize();
        SearchPredicate predicate = bool.toPredicate();
        SearchResult<PasswordJpaEntity> result = searchSession.search(scope).
                where(predicate).fetch(offset, criteria.getSize());

        List<PasswordJpaEntity> hits = result.hits();

        long totalCount = result.total().hitCount();
        int totalPages = (int) Math.ceil((double) totalCount / criteria.getSize());
        return new PageableResponse<>(PASSWORD_PERSISTENCE_MAPPER.mapToModel(hits), totalCount, totalPages, hits.size());
    }
}
