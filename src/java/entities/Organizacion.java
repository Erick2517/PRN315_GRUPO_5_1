
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
}