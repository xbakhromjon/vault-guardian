package uz.bakhromjon.persistence.password;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository extends JpaRepository<PasswordJpaEntity, Long> {
}
