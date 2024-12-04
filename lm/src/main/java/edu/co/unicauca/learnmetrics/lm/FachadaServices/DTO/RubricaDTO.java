package edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO;

import java.util.List;

import lombok.Data;

@Data
public class RubricaDTO {

    private Integer rubricaId;

    private String rubricaNombre;

    private ResultadoAprendizajeDTO RAS;

    private List<CriterioEvaluacionDTO> criterios;

}
