package mx.com.example.test.service.jpa;

import mx.com.example.test.dao.jpa.EmpleadoRepository;
import mx.com.example.test.dto.entity.Empleado;
import mx.com.example.test.dto.request.EmpleadoBeanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> getAll() {
        return empleadoRepository.getAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Empleado> insertAndGet(EmpleadoBeanRequest empleadoBeanRequest) throws Exception {
        Empleado empleado = new Empleado();
        empleado.setNombre(empleadoBeanRequest.getNombre());
        empleadoRepository.insert(empleado);


        boolean isTrue = true;
        /*
        if(isTrue) {
            throw new Exception("Error generado");
        }
        */

        return getAll();
    }
}
