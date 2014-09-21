package org.springframework.samples.petclinic.web;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Needed for customizing the ErrorController view added with WebAutoConfiguration.
 * 
 * @author Fabien Lauf
 *
 */
@Controller
public class CustomErrorController implements ErrorController {

	@RequestMapping(value = "/error")
	public String error() {
		return "exception";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
