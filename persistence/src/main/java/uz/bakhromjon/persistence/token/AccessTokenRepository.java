package uz.bakhromjon.persistence.token;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AccessTokenRepository extends JpaRepository<AccessTokenJpaEntity, String> {
    @Modifying
    void deleteByToken(String token);
}
