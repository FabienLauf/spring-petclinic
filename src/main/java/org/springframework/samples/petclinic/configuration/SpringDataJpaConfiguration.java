package org.springframework.samples.petclinic.configuration;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Profil specific configuration for the use of Spring Data JPA implementation
 * 
 * @author Fabien Lauf
 *
 */
@Profile("spring-data-jpa")
@Configuration
@EnableJpaRepositories("org.springframework.samples.petclinic.repository.springdatajpa")
@EntityScan("org.springframework.samples.petclinic.model")
public class SpringDataJpaConfiguration {

}
