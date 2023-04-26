package uz.bakhromjon.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "uz.bakhromjon")
@ComponentScan(basePackages = {"uz.bakhromjon"})
@EntityScan(basePackages = {"uz.bakhromjon"})
//@EnableJpaRepositories(basePackages = {"uz.bakhromjon"})
@EnableMongoRepositories(basePackages = {"uz.bakhromjon"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}



