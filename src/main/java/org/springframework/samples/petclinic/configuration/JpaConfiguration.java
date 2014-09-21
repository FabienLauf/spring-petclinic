package org.springframework.samples.petclinic.configuration;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Profil specific configuration for the use of Hibernate JPA implementation
 * 
 * @author Fabien Lauf
 *
 */
@Profile("jpa")
@Configuration
@ComponentScan("org.springframework.samples.petclinic.repository.jpa")
@EntityScan("org.springframework.samples.petclinic.model")
public class JpaConfiguration {

}
