package uz.bakhromjon.persistence.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import uz.bakhromjon.application.user.domain.User;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import({UserPersistenceAdapter.class})
class UserPersistenceAdapterTest {

    @Autowired
    private UserPersistenceAdapter adapterUnderTest;

    @Test
    void save() {
        User user = new User("xbakhromjon@gmail.com", "123", "123");
        User actual = adapterUnderTest.save(user);

        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getEmail()).isEqualTo("xbakhromjon@gmail.com");
        assertThat(actual.getMasterPassword()).isEqualTo("123");
        assertThat(actual.getHint()).isEqualTo("123");
    }

    @Test
    @Sql(scripts = "/data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void loadByEmail() {
        String email = "xbakhromjon1@gmail.com";
        User actual = adapterUnderTest.loadByEmail(email);

        assertThat(actual.getEmail()).isEqualTo(email);
    }
}
