package mx.com.example.test.application.producto.dao;


import mx.com.core.db.MySQLAutoEjecutable;
import mx.com.core.db.base.BaseResultado;
import mx.com.example.test.application.producto.dto.Producto;
import mx.com.example.test.application.producto.dto.ProductoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductoDAO {
    @Autowired
    private MySQLAutoEjecutable mySQLAutoEjecutable;

    public BaseResultado alta(ProductoWrapper producto) {
        BaseResultado resultado = null;

        Producto productoBD = new Producto();
        productoBD.setProducto(producto.getProducto());
        productoBD.setCosto(producto.getCosto());
        productoBD.setPrecio(producto.getPrecio());
        productoBD.setCodigoRapido(producto.getCodigoRapido());
        productoBD.setCodigoBarras(producto.getCodigoBarras());
        productoBD.setTipoVentaProd("U");
        productoBD.setEsGravable("N");
        productoBD.setEsIEPS("N");
        productoBD.setEsISH("N");
        productoBD.setCantidadMinima(producto.getCantidadMinima());
        productoBD.setCantidadMaxima(producto.getCantidadMaxima());

        productoBD.setMostrarResultado("S");
        productoBD.setIdUsuario(1);
        productoBD.setUuid(producto.getUuid());
        productoBD.setPrograma(producto.getPrograma());

        try {
            resultado = mySQLAutoEjecutable.alta(productoBD, BaseResultado.class);
            System.out.println(resultado.getNumResultado() + "-" + resultado.getResultado());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return resultado;
    }

    /*
    public List<ProductoBD> lista() {
        List<ProductoBD> lista = null;
        ProductoLis productoLis = new ProductoLis();
        productoLis.setPar_NumOpcion(1);


        try {
            lista = mySQLAutoEjecutable.getList(productoLis, ProductoBD.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    */

    /*
    public static void main(String[] args) {

        MySQLAutoEjecutable mysql = new MySQLAutoEjecutable();
        mysql.setLongUtils(new LongUtils());

        MySQ

        ProductoWrapper productoWrapper = new ProductoWrapper();
        productoWrapper.setPrecio("2.0");


        try {
            ProductoDAO productoDAO = new ProductoDAO();
            productoDAO.setMySQLAutoEjecutable(mysql);
            productoDAO.alta(productoWrapper);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    */

    public MySQLAutoEjecutable getMySQLAutoEjecutable() {
        return mySQLAutoEjecutable;
    }

    public void setMySQLAutoEjecutable(MySQLAutoEjecutable mySQLAutoEjecutable) {
        this.mySQLAutoEjecutable = mySQLAutoEjecutable;
    }
}
