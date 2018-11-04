package mx.com.example.test.controller;


import mx.com.example.test.dto.Producto;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/rest")
public class SprinRestController {
	final static Logger logger = Logger.getLogger("");

	public SprinRestController() {
		logger.info("SprinRestController - constructor()>>>>>>>>>>>>>>>>>>");
	}

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(HttpSession session) {
		logger.info("SprinRestController.welcomePage()>>>>>");
		logger.info("SprinRestController.welcomePage().success:" + session.getAttribute("success"));
		session.setAttribute("success" , "successfully accessed");
		return "response";
	}
}
