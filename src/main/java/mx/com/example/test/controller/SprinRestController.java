package mx.com.example.test.controller;


import mx.com.example.test.dto.entity.Empleado;
import mx.com.example.test.dto.request.BeanRequest;
import mx.com.example.test.dto.request.EmpleadoBeanRequest;
import mx.com.example.test.dto.response.BeanResponse;
import mx.com.example.test.service.hibernate.EmpleadoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class SprinRestController {
	@Autowired
	private EmpleadoService empleadoService;

	final static Logger logger = Logger.getLogger("");

	public SprinRestController() {
		logger.info("SprinRestController - constructor()>>>>>>>>>>>>>>>>>>");
	}
	
	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String welcomePage() {
		logger.info("welcomePage()>>>>>");
		return "response";
	}
	
	@RequestMapping(value = { "/rest" }, method = RequestMethod.POST)
	public BeanResponse restPage(@RequestBody BeanRequest bean) {
		logger.info("restPage()>>>>>");
		logger.info("bean:" + bean.getId() + " " + bean.getNombre());

		return new BeanResponse(1, "Julio perez");
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@RequestMapping(value = { "/listaEmpleados" }, method = RequestMethod.POST)
	public List<Empleado> listaEmpleados() {
		return empleadoService.getAll();
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = { "/insertaEmpleado" }, method = RequestMethod.POST)
	public List<Empleado> insertaEmpleado(@RequestBody EmpleadoBeanRequest empleadoBeanRequest) throws Exception {
        logger.info("insertaEmpleado()>>>>>");
        logger.info("empleadoBeanRequest:" + empleadoBeanRequest.getId() + " " + empleadoBeanRequest.getNombre());
		return empleadoService.insertAndGet(empleadoBeanRequest);
	}
}
