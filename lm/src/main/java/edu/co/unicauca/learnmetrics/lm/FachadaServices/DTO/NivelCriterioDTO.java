package edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica.enum_categoriaRUB;
import lombok.Data;

@Data
public class NivelCriterioDTO {
    private Integer idNivel;
    private enum_categoriaRUB categoriaNivel;
    private String descripcion;
    private CriterioEvaluacionDTO criterio;
}
