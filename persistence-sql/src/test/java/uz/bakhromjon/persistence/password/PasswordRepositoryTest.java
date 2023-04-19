package uz.bakhromjon.persistence.password;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
class PasswordRepositoryTest {

    @Autowired
    private PasswordRepository underTest;

    @Sql("PasswordRepositoryTest.sql")
    @Test
    void delete() {

    }
}

