package mx.com.example.test.config;


import java.io.Serializable;

import mx.com.example.test.dto.BeanRequest;
import mx.com.example.test.dto.BeanResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

	final static Logger logger = Logger.getLogger("");

	public HelloController() {
		logger.info("HelloController - constructor()>>>>>>>>>>>>>>>>>>");
		System.out.println("HelloController - constructor()>>>>>>>>>>>>>>>>>>");
	}
	
	@RequestMapping(value = { "/welcome2" }, method = RequestMethod.GET)
	public String welcomePage() {
		return "response";
	}
	
	@RequestMapping(value = { "/rest" }, method = RequestMethod.POST)
	public BeanResponse restPage(@RequestBody BeanRequest bean) {
		System.out.println("restPage()>>>>>");
		System.out.println("bean:" + bean.getId() + " " + bean.getNombre());

		return new BeanResponse(1, "Julio perez");
	}
}
