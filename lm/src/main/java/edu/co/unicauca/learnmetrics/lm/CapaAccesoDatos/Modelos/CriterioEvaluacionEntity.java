package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos;

import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Table(name = "TBL_CRITERIO_EVALUACION")
@Entity
public class CriterioEvaluacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CRIT_ID", nullable = false)
    private Integer idCriterio;

    @Column(name = "CRIT_DESCRIPCION", length = 250, nullable = false)
    private String descripcionCriterio;

    @Column(name = "CRIT_PONDERADO", nullable = false)
    private Integer ponderadoCriterio;

    @Column(name = "CRIT_NIVELES")
    private List<NivelCriterioEntity> niveles;

    @ManyToMany(mappedBy = "criterios")
    private List<RubricaEntity> rubricas;

    @ManyToMany
    @JoinTable(name = "TBL_CRITERIO_NIVEL", joinColumns = @JoinColumn(name = "CRIT_ID"), inverseJoinColumns = @JoinColumn(name = "NIVEL_ID"))
    private List<NivelCriterioEntity> nivelesCriterio;
}