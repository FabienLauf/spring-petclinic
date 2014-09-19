package org.springframework.samples.petclinic;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.samples.petclinic.application.PetClinicApplication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PetClinicApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
// @DirtiesContext
@ActiveProfiles("spring-data-jpa")
public class StartupTimeTest {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(StartupTimeTest.class);

    @Autowired
    private WebApplicationContext webApplicationContext;
    
	@Test
	public void webAppAndSpringDataJpa(){
		long startupTime = System.currentTimeMillis() - webApplicationContext.getStartupDate();
		
		LOGGER.info(String.format("Startup Time : %d sec", TimeUnit.MILLISECONDS.toSeconds(startupTime)));
		
		Assert.assertTrue(startupTime > 1);
	}
}
