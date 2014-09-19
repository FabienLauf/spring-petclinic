
package org.springframework.samples.petclinic.service;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.samples.petclinic.application.PetClinicApplication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p> Integration test using the 'Spring Data' profile. 
 * @see AbstractClinicServiceTests AbstractClinicServiceTests for more details. </p>
 * @author Michael Isvy
 */

@SpringApplicationConfiguration(classes = PetClinicApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("spring-data-jpa")
// @DirtiesContext
public class ClinicServiceSpringDataJpaTests extends AbstractClinicServiceTests {

}