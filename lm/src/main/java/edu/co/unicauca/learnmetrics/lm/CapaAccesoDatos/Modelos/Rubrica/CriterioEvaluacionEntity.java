package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica;

import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "tbl_criterio_evaluacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CriterioEvaluacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CRITERIO_ID", nullable = false)
    private Integer idCriterio;

    @Column(name = "CRITERIO_NOMBRE", nullable = false)
    private String nombre;

    @ManyToMany
    @JoinTable(
            name = "tbl_criterio_nivel",
            joinColumns = @JoinColumn(name = "CRITERIO_ID"),
            inverseJoinColumns = @JoinColumn(name = "NIVEL_ID")
    )
    private List<NivelCriterioEntity> nivelesCriterio;
}