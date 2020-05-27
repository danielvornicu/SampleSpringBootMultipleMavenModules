package tech.dev.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Description de la classe
 * <p>
 * Date: 20/05/2020
 *
 * @author d.vornicu
 * @version 1.0 $Revision$ $Date$
 */

// same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication
@EnableJpaRepositories(basePackages = {"tech.dev.db"})
@EntityScan(basePackages = {"tech.dev.entities"})
@ComponentScan(basePackages = {"tech.dev.*"})
public class SimpleSpringBootApplication {
    private static Logger LOGGER = LoggerFactory.getLogger(SimpleSpringBootApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SimpleSpringBootApplication.class, args);
        LOGGER.debug("Spring Boot application ready");
    }



}
