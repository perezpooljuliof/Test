package mx.com.example.test.dto;

/**
 * Created by elver on 5/09/17.
 */
public class BeanRequest {
    private String nombre;
    private String id;

    public BeanRequest() {
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
