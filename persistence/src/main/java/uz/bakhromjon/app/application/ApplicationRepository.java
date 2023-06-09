package uz.bakhromjon.app.application;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<ApplicationJpaEntity, Long> {

}
