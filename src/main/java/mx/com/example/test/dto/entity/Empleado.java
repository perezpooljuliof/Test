package mx.com.example.test.dto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by elver on 9/09/17.
 */
@Entity
@Table(name = "Empleado")
public class Empleado {
    private int id;
    private String nombre;

    @Id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
