package mx.com.example.test.dto;

/**
 * Created by elver on 5/09/17.
 */
public class BeanResponse {

    private String nombre;
    private int id;

    public BeanResponse() {}

    public BeanResponse(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
