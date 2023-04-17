package uz.bakhromjon.persistence.password;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Transactional
@Repository
public interface PasswordRepository extends JpaRepository<PasswordJpaEntity, Long> {
    Optional<PasswordJpaEntity> findByIdAndOwnerId(long passwordId, long ownerId);

    @EntityGraph(attributePaths = "owner")
    @Query("select p from PasswordJpaEntity p where p.id = :passwordId and p.owner.id = :ownerId")
    Optional<PasswordJpaEntity> findByIdAndOwnerIdForUpdate(@Param(value = "passwordId") long passwordId, @Param(value = "ownerId") long ownerId);
}
