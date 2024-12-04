package edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO;

import java.util.List;

import lombok.Data;

@Data
public class CriterioEvaluacionDTO {
    private Integer idCriterio;
    private String descripcionCriterio;
    private Double nota;
    private Double ponderacion;
    private RubricaDTO rubrica;
    private List<NivelCriterioDTO> nivelesCriterio;
}
