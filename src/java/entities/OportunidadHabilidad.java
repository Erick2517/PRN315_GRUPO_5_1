
package entities;


import java.io.Serializable;
import javax.persistence.*;

@Entity
public class OportunidadHabilidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idHabilidad")
    private Habilidades habilidad;

    @ManyToOne
    @JoinColumn(name = "idOportunidad")
    private OportunidadVolun oportunidadVolun;

    // Getters y Setters
}