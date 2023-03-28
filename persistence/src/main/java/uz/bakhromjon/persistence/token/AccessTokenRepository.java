package uz.bakhromjon.persistence.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessTokenRepository extends JpaRepository<AccessTokenJpaEntity, String> {
}
