package uz.bakhromjon.persistence.passport;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PassportRepository extends MongoRepository<PassportDocument, Long> {
    Optional<PassportDocument> findByIdAndOwnerId(Long passwordId, long ownerId);

//    @Query("select p from PassportJpaEntity p where p.id = :passwordId and p.owner.id = :ownerId")
//    Optional<PassportDocument> findByIdAndOwnerIdForUpdate(@Param(value = "passwordId") long passwordId, @Param(value = "ownerId") long ownerId);
}
