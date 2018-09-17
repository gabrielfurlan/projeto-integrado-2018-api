package server;

import javax.persistence.Index;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import controllers.IndexController;
import services.IndexService;
import repositories.IndexRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"repositories"})
@ComponentScan(basePackages = {"controllers", "repositories", "services"})
@EntityScan(basePackages = {"models"})
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}