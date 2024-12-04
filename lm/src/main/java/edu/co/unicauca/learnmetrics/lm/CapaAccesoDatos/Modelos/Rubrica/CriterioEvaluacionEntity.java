package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @Column(name = "CRITERIO_DESC", nullable = false)
    private String descripcionCriterio;

    @Column(name = "CRITERIO_NOTA", nullable = true)
    private Double nota;

    @Column(name = "CRITERIO_PONDERACION", nullable = false)
    private Double ponderacion;

    @ManyToOne
    @JoinColumn(name = "RUB_ID")
    @JsonBackReference
    private RubricaEntity rubrica;

    @OneToMany(mappedBy = "criterio", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<NivelCriterioEntity> nivelesCriterio;
}