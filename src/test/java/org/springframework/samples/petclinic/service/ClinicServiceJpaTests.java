
package org.springframework.samples.petclinic.service;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.samples.petclinic.application.PetClinicApplication;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p> Integration test using the jpa profile. 
 * @see AbstractClinicServiceTests AbstractClinicServiceTests for more details. </p>
 *
 * @author Rod Johnson
 * @author Sam Brannen
 * @author Michael Isvy
 */

@SpringApplicationConfiguration(classes = PetClinicApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("jpa")
// @DirtiesContext
public class ClinicServiceJpaTests extends AbstractClinicServiceTests {

}