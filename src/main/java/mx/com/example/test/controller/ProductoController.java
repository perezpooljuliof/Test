package mx.com.example.test.controller;

import mx.com.core.db.BaseResultado;
import mx.com.example.test.dto.Producto;
import mx.com.example.test.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @RequestMapping(value = {"/altaProducto"}, method = RequestMethod.POST)
    public BaseResultado altaProducto(@RequestBody Producto producto) {
        BaseResultado resultado = productoService.alta(producto);
        return resultado;
    }
}
