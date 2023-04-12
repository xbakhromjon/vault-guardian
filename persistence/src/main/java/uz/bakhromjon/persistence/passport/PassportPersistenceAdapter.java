package uz.bakhromjon.persistence.passport;

import lombok.RequiredArgsConstructor;
import org.hibernate.search.engine.search.predicate.SearchPredicate;
import org.hibernate.search.engine.search.predicate.dsl.BooleanPredicateClausesStep;
import org.hibernate.search.engine.search.query.SearchResult;
import org.hibernate.search.mapper.orm.scope.SearchScope;
import org.hibernate.search.mapper.orm.session.SearchSession;
import uz.bakhromjon.application.common.PageableResponse;
import uz.bakhromjon.application.passport.application.port.in.criteria.PassportSearchCriteria;
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

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class PassportPersistenceAdapter implements SavePassportPort, LoadPassportPort, DeletePassportPort {
    private final PassportRepository passportRepository;
    private final PassportPersistenceMapper PASSPORT_PERSISTENCE_MAPPER = PassportPersistenceMapper.INSTANCE;
    private final SearchSession searchSession;
    private final LoadUserPort loadUserPort;

    @Override
    public Passport save(Passport passport) {
        if (!loadUserPort.existsById(passport.getOwnerId())) {
            throw new DataNotFoundException(PersistenceErrorMessage.USER_NOT_FOUND, new ErrorData(PersistenceErrorDataKey.USER_ID, passport.getOwnerId()));
        }
        PassportJpaEntity entity = PASSPORT_PERSISTENCE_MAPPER.mapToEntity(passport);
        entity = passportRepository.save(entity);
        return PASSPORT_PERSISTENCE_MAPPER.mapToModel(entity);
    }

    @Override
    public Passport load(Passport.PassportId passportId, User.UserId requestedUserId) {
        Optional<PassportJpaEntity> passportOptional = passportRepository.findByIdAndOwnerId(passportId.getValue(), requestedUserId.getValue());
        PassportJpaEntity entity = passportOptional.orElseThrow(() -> {
            throw new DataNotFoundException(PersistenceErrorMessage.PASSPORT_NOT_FOUND, new ErrorData(PersistenceErrorDataKey.PASSPORT_ID, passportId));
        });
        return PASSPORT_PERSISTENCE_MAPPER.mapToModel(entity);
    }

    @Override
    public void deleteById(Passport.PassportId id) {
        passportRepository.deleteById(id.getValue());
    }

    @Override
    public PageableResponse<Passport> search(PassportSearchCriteria criteria) {
        SearchScope<PassportJpaEntity> scope = searchSession.scope(PassportJpaEntity.class);
        BooleanPredicateClausesStep<?> bool = scope.predicate().bool();

        if (Objects.nonNull(criteria.getSearch()) && !criteria.getSearch().isBlank()) {
            bool.must(scope.predicate().match().fields("name", "number", "notes").matching(criteria.getSearch()));
        }

        int offset = criteria.getPage() * criteria.getSize();
        SearchPredicate predicate = bool.toPredicate();
        SearchResult<PassportJpaEntity> result = searchSession.search(scope).
                where(predicate).fetch(offset, criteria.getSize());

        List<PassportJpaEntity> hits = result.hits();

        long totalCount = result.total().hitCount();
        int totalPages = (int) Math.ceil((double) totalCount / criteria.getSize());
        return new PageableResponse<>(PASSPORT_PERSISTENCE_MAPPER.mapToModel(hits), totalCount, totalPages, hits.size());
    }

}
