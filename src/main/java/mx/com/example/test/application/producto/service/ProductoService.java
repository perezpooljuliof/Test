package mx.com.example.test.application.producto.service;


import mx.com.core.db.base.BaseResultado;
import mx.com.example.test.application.producto.dao.ProductoDAO;
import mx.com.example.test.application.producto.dto.ProductoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    private ProductoDAO productoDAO;

    public BaseResultado alta(ProductoWrapper producto) {
        return productoDAO.alta(producto);
    }
}
