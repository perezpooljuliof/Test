package mx.com.example.test.dto.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by elver on 9/09/17.
 */
@Entity
@Table(name = "Usuario")
public class Usuario {
    private int id;
    private String usuario;
    private String password;
    private String semilla;

    @Id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "usuario")
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "semilla")
    public String getSemilla() {
        return semilla;
    }
    public void setSemilla(String semilla) {
        this.semilla = semilla;
    }
}
