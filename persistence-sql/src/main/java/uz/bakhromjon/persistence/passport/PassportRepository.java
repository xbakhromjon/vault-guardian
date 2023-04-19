package uz.bakhromjon.persistence.passport;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PassportRepository extends JpaRepository<PassportJpaEntity, Long> {
    Optional<PassportJpaEntity> findByIdAndOwnerId(Long passwordId, long ownerId);

    @EntityGraph(attributePaths = "owner")
    @Query("select p from PassportJpaEntity p where p.id = :passwordId and p.owner.id = :ownerId")
    Optional<PassportJpaEntity> findByIdAndOwnerIdForUpdate(@Param(value = "passwordId") long passwordId, @Param(value = "ownerId") long ownerId);
}
