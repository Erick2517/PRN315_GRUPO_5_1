package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuariosHabilidades")
public class UsuariosHabilidades implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "idHabilidad", referencedColumnName = "id")
    private Habilidades habilidad;

    // Constructor por defecto
    public UsuariosHabilidades() {}

    // Constructor con parámetros
    public UsuariosHabilidades(Usuarios usuario, Habilidades habilidad) {
        this.usuario = usuario;
        this.habilidad = habilidad;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Habilidades getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(Habilidades habilidad) {
        this.habilidad = habilidad;
    }

    // Método toString (opcional)
    @Override
    public String toString() {
        return "UsuariosHabilidades{" +
                "id=" + id +
                ", usuario=" + (usuario != null ? usuario.getId() : "null") +
                ", habilidad=" + (habilidad != null ? habilidad.getId() : "null") +
                '}';
    }
}
