package mx.com.example.test.service;

import mx.com.core.db.BaseResultado;
import mx.com.example.test.dao.ProductoDAO;
import mx.com.example.test.dto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
    @Autowired
    private ProductoDAO productoDAO;

    public BaseResultado alta(Producto producto) {
        return productoDAO.alta(producto);
    }
}
