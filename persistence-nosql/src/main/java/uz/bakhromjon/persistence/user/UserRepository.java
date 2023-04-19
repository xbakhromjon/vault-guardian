package uz.bakhromjon.persistence.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserDocument, Long> {
    Optional<UserDocument> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsById(long id);
}
