package mx.com.example.test.dao;

import mx.com.example.test.dto.entity.Empleado;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by elver on 10/09/17.
 */
@Repository
public class EmpleadoDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public List<Empleado> getAll() {
        String sql = "select e from Empleado e";
        Query query = sessionFactory.openSession().createQuery(sql);
        return query.list();
    }

    public void insert(Empleado empleado) {
        sessionFactory.openSession().save(empleado);
    }
}
