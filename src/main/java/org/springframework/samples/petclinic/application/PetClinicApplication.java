package org.springframework.samples.petclinic.application;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * The Main Application class.<br>
 * {@link org.springframework.boot.context.web.SpringBootServletInitializer
 * SpringBootServletInitializer} is needed when packaging as a WAR.
 * 
 * @author Fabien Lauf
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
({
	"org.springframework.samples.petclinic.configuration",
	"org.springframework.samples.petclinic.service",
	"org.springframework.samples.petclinic.web"
})
public class PetClinicApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PetClinicApplication.class); 
	}
	
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(PetClinicApplication.class, args);
		
		System.out.println("Active Profiles: "+Arrays.toString(ctx.getEnvironment().getActiveProfiles()));
		
		System.out.println("Let's inspect the beans provided by Spring Boot:");
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
		
	}
}
