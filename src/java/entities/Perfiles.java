package entities;

import entities.Usuarios;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "perfiles")
public class Perfiles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "puntos")
    private Integer puntos;

    @Column(name = "rango")
    private String rango;

    @OneToOne
    @JoinColumn(name = "idUsuario", referencedColumnName = "id")
    private Usuarios usuario;

    // Constructor por defecto
    public Perfiles() {}

    // Constructor con parámetros
    public Perfiles(Integer puntos, String rango, Usuarios usuario) {
        this.puntos = puntos;
        this.rango = rango;
        this.usuario = usuario;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Perfiles{" +
                "id=" + id +
                ", puntos=" + puntos +
                ", rango='" + rango + '\'' +
                ", usuario=" + (usuario != null ? usuario.getId() : "null") +
                '}';
    }
}