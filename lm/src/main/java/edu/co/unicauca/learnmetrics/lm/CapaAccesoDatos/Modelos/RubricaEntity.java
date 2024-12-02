package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_RUBRICA")
public class RubricaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RUB_ID", nullable = false)
    private Long rubricaId;

    @Column(name = "RUB_NOMBRE", length = 50, nullable = false)
    private String rubricaNombre;

    @ManyToMany(mappedBy = "rubricas")
    private List<ResultadoAprendizajeEntity> RAS;

    @ManyToMany
    @JoinTable(name = "TBL_RUBRICA_CRITERIO", joinColumns = @JoinColumn(name = "RUB_ID"), inverseJoinColumns = @JoinColumn(name = "CRIT_ID"))
    private List<CriterioEvaluacionEntity> criterios;

    private Date fechaCreacion;

    private Date fechaModificacion;

    private boolean rubricaEstado;
}