package pe.isil.moduloseguridad.visita;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "tbl_visitas",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "DNI", name = "DNI_unique")
        })
public class Visita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String local;
    private String DNI;

    private Date fechaCreacion;

    @PostPersist
    public void postPersist() {
        this.fechaCreacion = new Date();
    }
}
