package mx.com.example.test.dao;

import mx.com.core.db.BaseResultado;
import mx.com.core.db.MySQLAutoEjecutable;
import mx.com.example.test.dao.store.ProductoAlt;
import mx.com.example.test.dao.store.ProductoLis;
import mx.com.example.test.dto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductoDAO {

    @Autowired
    private MySQLAutoEjecutable mySQLAutoEjecutable;

    public BaseResultado alta(Producto producto) {
        BaseResultado resultado = null;

        ProductoAlt productoDAO = new ProductoAlt();
        productoDAO.setPar_IDProducto(0);
        productoDAO.setPar_Producto(producto.getProducto());
        productoDAO.setPar_Costo(Double.parseDouble(producto.getCosto()));
        productoDAO.setPar_Precio(Double.parseDouble(producto.getPrecio()));
        productoDAO.setPar_CodigoBarras(producto.getCodigoBarras());
        productoDAO.setPar_TipoVentaProd("U");
        productoDAO.setPar_EsGravable("N");
        productoDAO.setPar_EsIEPS("N");
        productoDAO.setPar_EsISH("N");
        productoDAO.setPar_CantidadMinima(Double.parseDouble(producto.getCantidadMinima()));
        productoDAO.setPar_CantidadMaxima(Double.parseDouble(producto.getCantidadMinima()));
        productoDAO.setPar_MostrarResultado("S");
        productoDAO.setPar_IDUsuario(1);
        productoDAO.setPar_UUID("123");

        try {
            resultado = mySQLAutoEjecutable.getResult(productoDAO, BaseResultado.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    public List<Producto> lista() {
        List<Producto> lista = null;
        ProductoLis productoLis = new ProductoLis();
        productoLis.setPar_NumOpcion(1);


        try {
            lista = mySQLAutoEjecutable.getList(productoLis, Producto.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    /*
    public static void main(String[] args) {


        ProductoLis productoLis = new ProductoLis();
        productoLis.setPar_NumOpcion(1);

        try {
            MySQLAutoEjecutable dao = new MySQLAutoEjecutable();

            System.out.println(resultado.getNumResultado() + " " + resultado.getResultado());

            List<Producto> productos = dao.getList(productoLis, Producto.class);
            for(Producto producto: productos) {
                System.out.println(producto);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    */

}
