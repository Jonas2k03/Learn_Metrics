package edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO;

import java.util.Date;
import java.util.List;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.RA.ResultadoAprendizajeEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica.CriterioEvaluacionEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RubricaDTO {
  
    private Long rubricaId;
    private String rubricaNombre;
    private ResultadoAprendizajeEntity resAprendizaje;
    private List<CriterioEvaluacionEntity> criterios;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private boolean rubricaEstado;
}
