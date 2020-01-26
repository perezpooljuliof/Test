package mx.com.example.test.application.producto.service;


import mx.com.core.db.base.BaseResultado;
import mx.com.core.utilidades.LongUtils;
import mx.com.example.test.application.producto.dao.ProductoDAO;
import mx.com.example.test.application.producto.dto.ProductoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class ProductoService {
    @Autowired
    private ProductoDAO productoDAO;
    @Autowired
    private LongUtils longUtils;
    @Autowired
    private PlatformTransactionManager transactionManager;

    public BaseResultado alta(ProductoWrapper producto) {
        addUuid(producto);

        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);
        BaseResultado resultado = null;
        try {
            resultado = productoDAO.alta(producto);
            if(!"0".equals(resultado.getNumResultado())) {
                throw new Exception(resultado.getNumResultado() + "-" + resultado.getResultado());
            }
            transactionManager.commit(status);
        }
        catch(Exception e) {
            e.printStackTrace();
            transactionManager.rollback(status);
        }
        return resultado;
    }

    private void addUuid(BaseResultado bean) {
        long uuid = longUtils.generateUniqueID();
        bean.setUuid(uuid);
    }

    public ProductoDAO getProductoDAO() {
        return productoDAO;
    }
    public void setProductoDAO(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public LongUtils getLongUtils() {
        return longUtils;
    }
    public void setLongUtils(LongUtils longUtils) {
        this.longUtils = longUtils;
    }
}
