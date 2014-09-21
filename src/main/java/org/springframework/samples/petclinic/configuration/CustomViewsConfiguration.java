package org.springframework.samples.petclinic.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.samples.petclinic.model.Vets;
import org.springframework.samples.petclinic.web.VetsAtomView;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

/**
 * Spring Boot automatically adds the following ViewBeans below into a BeanNameViewResolver already
 * present in the context thanks to the WebAutoConfiguration.
 * 
 * @author Fabien Lauf
 *
 */
@Configuration
public class CustomViewsConfiguration {

	/**
	 * {@link BeanNameViewResolver} is used to resolve the Atom and Xml views.
	 * So, the following beans names must match the name of the JSP you want to override and the file extension will indicate which bean to use for resolving.
	 */
	@Bean(name="vets/vetList.atom")
	public VetsAtomView vetsAtomView() {
		return new VetsAtomView();
	}
	
	@Bean(name="vets/vetList.xml")
	public MarshallingView vetsXmlView() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Vets.class);
		return new MarshallingView(marshaller);
	}
}
