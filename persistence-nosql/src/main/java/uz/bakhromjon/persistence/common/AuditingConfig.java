package uz.bakhromjon.persistence.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@Configuration
//@EnableTransactionManagement
////@EnableMongoAuditing
//public class AuditingConfig {
//
//    @Bean
//    AuditorAware<Long> auditorAware() {
//        return new AuditorAwareImpl();
//    }
//}
