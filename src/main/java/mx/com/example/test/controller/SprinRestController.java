package mx.com.example.test.controller;


import mx.com.example.test.dto.request.BeanRequest;
import mx.com.example.test.dto.response.BeanResponse;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/rest")
public class SprinRestController {

	final static Logger logger = Logger.getLogger("");

	public SprinRestController() {
		logger.info("SprinRestController - constructor()>>>>>>>>>>>>>>>>>>");
		System.out.println("SprinRestController - constructor()>>>>>>>>>>>>>>>>>>");
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
