package uz.bakhromjon.persistence.passport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PassportRepository extends JpaRepository<PassportJpaEntity, Long> {
    Optional<PassportJpaEntity> findByIdAndOwnerId(Long passwordId, long ownerId);
}
