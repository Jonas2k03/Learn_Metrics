package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CriterioEvaluacionEntity {

    private Integer idCriterio;

    private String descripcionCriterio;

    private Integer ponderadoCriterio;

    private NivelCriterioEntity nivel;
}