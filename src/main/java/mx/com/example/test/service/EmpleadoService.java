package mx.com.example.test.service;

import mx.com.example.test.dao.EmpleadoDAO;
import mx.com.example.test.dto.entity.Empleado;
import mx.com.example.test.dto.request.EmpleadoBeanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by elver on 10/09/17.
 */
@Controller
public class EmpleadoService {
    @Autowired
    private EmpleadoDAO empleadoDAO;

    public List<Empleado> getAll() {
        return empleadoDAO.getAll();
    }

    @Transactional
    public List<Empleado> insertAndGet(EmpleadoBeanRequest empleadoBeanRequest) {
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoBeanRequest.getNombre());
        empleadoDAO.insert(empleado);

        return getAll();
    }

}
