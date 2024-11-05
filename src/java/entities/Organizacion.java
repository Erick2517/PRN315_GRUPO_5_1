
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Organizacion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;

    @OneToMany(mappedBy = "organizacion")
    private List<OportunidadVolun> oportunidadesVolun;

    // Getters y Setters

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}