package uz.bakhromjon.persistence.token;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface AccessTokenRepository extends MongoRepository<AccessTokenDocument, String> {
    void deleteByToken(String token);
}
