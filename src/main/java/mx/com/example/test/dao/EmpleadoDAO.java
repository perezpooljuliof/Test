package mx.com.example.test.dao;

import mx.com.example.test.dto.entity.Empleado;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by elver on 10/09/17.
 */
@Repository
public class EmpleadoDAO {
    @Autowired
    private SessionFactory sessionFactory;

    final static Logger logger = Logger.getLogger(EmpleadoDAO.class);

    public List<Empleado> getAll() {
        String sql = "select e from Empleado e";
        Query query = sessionFactory.openSession().createQuery(sql);
        return query.list();
    }

    @Transactional
    public void insert(Empleado empleado) {
        logger.info("insert");
        sessionFactory.openSession().save(empleado);
    }
}
