package mx.com.example.test.application.producto.controller;



import mx.com.core.db.base.BaseResultado;
import mx.com.example.test.application.producto.dto.ProductoWrapper;
import mx.com.example.test.application.producto.service.ProductoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by elver on 5/09/17.
 */
@Controller
@RequestMapping(value = "/Web/Producto")
public class ProductoWebController {
    @Autowired
    private ProductoService productoService;

    final static Logger logger = Logger.getLogger("");

    /**
     * Pagina principal del Inventario.
     *
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = {"/Inventario"}, method = RequestMethod.GET)
    public String inventario(ModelMap model) throws Exception {
        return "producto/inventario";
    }

    /**
     * EndPoint para el alta de nuevos productos.
     *
     * @param producto
     * @return
     */
    @RequestMapping(path = "/AltaProducto", method = RequestMethod.POST)
    public @ResponseBody BaseResultado altaProducto(@RequestBody ProductoWrapper producto) {
        producto.setPrograma("/Web/Producto/AltaProducto");
        return productoService.alta(producto);
    }
}


