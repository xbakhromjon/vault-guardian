package uz.bakhromjon.persistence.password;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PasswordRepository extends JpaRepository<PasswordJpaEntity, Long> {
    Optional<PasswordJpaEntity> findByIdAndOwnerId(long passwordId, long ownerId);
}
