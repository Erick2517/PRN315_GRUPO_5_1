
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class OportunidadVolun implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToOne
    @JoinColumn(name = "idOrganizacion")
    private Organizacion organizacion;

    @OneToMany(mappedBy = "oportunidadVolun")
    private List<RegistroVolun> registrosVolun;

    @OneToMany(mappedBy = "oportunidadVolun")
    private List<OportunidadHabilidad> oportunidadHabilidades;

    // Getters y Setters
}