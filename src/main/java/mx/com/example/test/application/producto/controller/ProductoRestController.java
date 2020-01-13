package mx.com.example.test.application.producto.controller;



import mx.com.core.db.base.BaseResultado;
import mx.com.example.test.application.producto.dto.ProductoWrapper;
import mx.com.example.test.application.producto.service.ProductoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/Rest")
public class ProductoRestController {
    @Autowired
    private ProductoService productoService;

	final static Logger logger = Logger.getLogger("");

	@RequestMapping(value = { "/Producto/welcome" }, method = RequestMethod.POST)
	public String welcomePage(HttpSession session) {
		logger.info("ProductoRestController.welcomePage()>>>>>");
		logger.info("ProductoRestController.welcomePage().success:" + session.getAttribute("success"));
		session.setAttribute("success" , "successfully accessed");
		return "response";
	}

	@RequestMapping(value = { "/Producto/welcome2" }, method = RequestMethod.POST)
	public String welcomePage2(HttpSession session) {
		logger.info("ProductoRestController.welcomePage()>>>>>");
		logger.info("ProductoRestController.welcomePage().success:" + session.getAttribute("success"));
		session.setAttribute("success" , "successfully accessed");
		return "response";
	}

	@RequestMapping(value="/Admin/altaProducto", method = RequestMethod.POST)
	public BaseResultado altaProducto(@RequestBody ProductoWrapper productoWrapper) {
		System.out.println(this.getClass().getSimpleName() + ".altaProducto");
		BaseResultado resultado = productoService.alta(productoWrapper);
		return resultado;
	}

	@RequestMapping(value = {"/Admin/altaProducto2"}, method = RequestMethod.POST)
	public BaseResultado altaProducto2(@RequestBody ProductoWrapper productoWrapper) {
		BaseResultado resultado = productoService.alta(productoWrapper);
		return resultado;
	}
}
