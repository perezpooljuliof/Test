package mx.com.example.test.service.hibernate;

import mx.com.example.test.dao.hibernate.EmpleadoDAO;
import mx.com.example.test.dto.entity.Empleado;
import mx.com.example.test.dto.request.EmpleadoBeanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by elver on 10/09/17.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class EmpleadoService {
    @Autowired
    private EmpleadoDAO empleadoDAO;

    public List<Empleado> getAll() {
        return empleadoDAO.getAll();
    }


    public List<Empleado> insertAndGet(EmpleadoBeanRequest empleadoBeanRequest) throws Exception {
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoBeanRequest.getNombre());
        empleadoDAO.insert(empleado);


        boolean isTrue = true;

        if(isTrue) {
            throw new Exception("Error generado");
        }



        return getAll();
    }
}

