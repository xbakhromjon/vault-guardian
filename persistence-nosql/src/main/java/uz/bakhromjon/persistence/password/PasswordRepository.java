package uz.bakhromjon.persistence.password;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface PasswordRepository extends MongoRepository<PasswordDocument, Long> {
    Optional<PasswordDocument> findByIdAndOwnerId(long passwordId, long ownerId);

//    @Query("select p from PasswordJpaEntity p where p.id = :passwordId and p.owner.id = :ownerId")
//    Optional<PasswordDocument> findByIdAndOwnerIdForUpdate(@Param(value = "passwordId") long passwordId, @Param(value = "ownerId") long ownerId);
}
