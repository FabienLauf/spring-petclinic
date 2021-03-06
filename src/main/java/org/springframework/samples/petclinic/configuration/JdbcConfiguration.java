package org.springframework.samples.petclinic.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Profil specific configuration for the use of JDBC implementation
 * 
 * @author Fabien Lauf
 *
 */
@Profile("jdbc")
@Configuration
@ComponentScan({ "org.springframework.samples.petclinic.repository.jdbc" })
public class JdbcConfiguration {

}
