package org.springframework.samples.petclinic.configuration;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.dandelion.core.web.DandelionFilter;
import com.github.dandelion.core.web.DandelionServlet;
import com.github.dandelion.datatables.core.web.filter.DatatablesFilter;
import com.github.dandelion.datatables.thymeleaf.dialect.DataTablesDialect;

@Configuration
public class DandelionConfiguration {

	@Bean
	public DataTablesDialect dataTablesDialect() {
		return new DataTablesDialect();
	}

	@Bean
	public ServletRegistrationBean dandelionServlet() {
		ServletRegistrationBean srb = new ServletRegistrationBean(new DandelionServlet(), "/dandelion-assets/*");
		srb.setLoadOnStartup(2);
		return srb;
	}

	@Bean
	public FilterRegistrationBean dandelionFilter() {
		FilterRegistrationBean frb = new FilterRegistrationBean(new DandelionFilter());
		return frb;
	}

	@Bean
	public FilterRegistrationBean datatables() {
		FilterRegistrationBean frb = new FilterRegistrationBean(new DatatablesFilter());
		return frb;
	}

}
