package mx.com.example.test.dao.jpa;

import mx.com.example.test.dto.entity.Empleado;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

@Repository
public class EmpleadoRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Empleado> getAll() {
        Query query = entityManager.createQuery("Select e from Empleado e");
        List<Empleado> empleados = query.getResultList();
        return empleados;
    }

    @Transactional
    public void insert(Empleado empleado) {
        entityManager.persist(empleado);
    }
}
