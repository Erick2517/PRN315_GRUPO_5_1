
package entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
public class RegistroVolun implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numeroHoras;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "idOportunidad")
    private OportunidadVolun oportunidadVolun;

    // Getters y Setters
}
