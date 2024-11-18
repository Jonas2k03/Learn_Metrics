package edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO;

import java.util.List;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica.RubricaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResultadoAprendizajeDTO {
    private int idRA;
    private String descripcionRA;
    private List<RubricaEntity> rubricas;

    public ResultadoAprendizajeDTO() {
    }
}
