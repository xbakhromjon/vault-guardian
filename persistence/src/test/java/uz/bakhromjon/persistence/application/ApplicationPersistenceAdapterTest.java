package uz.bakhromjon.persistence.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import uz.bakhromjon.application.application.domain.Application;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@Import({ApplicationPersistenceAdapter.class})
class ApplicationPersistenceAdapterTest {
    @Autowired
    private ApplicationPersistenceAdapter adapterUnderTest;

    @Test
    void loadById() {
        Application expected = Application.builder().id(1L).applicantId(1L).message("M1").isDeleted(Boolean.FALSE).build();
        Application actual = adapterUnderTest.loadById(1L);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void save() {
        Application application = Application.builder().applicantId(1L).message("M").isDeleted(Boolean.FALSE).build();
        Application actual = adapterUnderTest.save(application);

        assertThat(actual.getId()).isNotNull();
        assertThat(actual.getApplicantId()).isEqualTo(1L);
        assertThat(actual.getMessage()).isEqualTo("M");
        assertThat(actual.getIsDeleted()).isEqualTo(Boolean.FALSE);
    }
}
