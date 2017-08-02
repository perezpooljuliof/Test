package mx.com.example.test.config;


import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

	final static Logger logger = Logger.getLogger(HelloController.class.getName());

	public HelloController() {
		logger.info("HelloController - constructor()>>>>>>>>>>>>>>>>>>");
		logger.error("Error()>>>>>>>>>>>");
		System.out.println("HelloController - constructor()>>>>>>>>>>>>>>>>>>");
	}
	
	@RequestMapping(value = { "/welcome2" }, method = RequestMethod.GET)
	public String welcomePage() {
		return "response";
	}
	
	
	@RequestMapping(value = { "/rest" }, method = RequestMethod.POST)
	public String restPage(@RequestBody BeanResponse bean) {
		System.out.println(bean.getNombre() + " " + bean.getId());
		//return new BeanResponse(1, "Julio perez");
		return "response";
	}
	
	@RequestMapping(value = { "/rest2" }, method = RequestMethod.GET)
	public BeanResponse restPage2() {
		System.out.println("restPage2");
		return new BeanResponse(1, "Julio perez");
	}
	
	public class BeanResponse implements Serializable {		
		
		private String nombre;
		private int id;
		
		public BeanResponse() {}
		
		public BeanResponse(int id, String nombre) {
			this.id = id;
			this.nombre = nombre;
		}
		
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}
	}
}
