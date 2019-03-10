package mx.com.example.test.application.producto.controller;


import mx.com.core.db.BaseResultado;
import mx.com.example.test.application.producto.dto.Producto;
import mx.com.example.test.application.producto.service.ProductoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/Rest/Producto")
public class ProductoRestController {
    @Autowired
    private ProductoService productoService;

	final static Logger logger = Logger.getLogger("");

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public String welcomePage(HttpSession session) {
		logger.info("ProductoRestController.welcomePage()>>>>>");
		logger.info("ProductoRestController.welcomePage().success:" + session.getAttribute("success"));
		session.setAttribute("success" , "successfully accessed");
		return "response";
	}

	@RequestMapping(value = {"/altaProducto"}, method = RequestMethod.POST)
	public BaseResultado altaProducto(@RequestBody Producto producto) {
		BaseResultado resultado = productoService.alta(producto);
		return resultado;
	}
}
