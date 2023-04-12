package uz.bakhromjon.persistence.common;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.hibernate.search.mapper.orm.Search;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HibernateConfig {
    @Transactional
    @Bean
    public SearchSession searchSession(EntityManager entityManager) {
        return Search.session(entityManager);
    }
}
