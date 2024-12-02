package edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO;

import java.util.List;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.ResultadoAprendizajeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompetenciaDTO {

    private Integer compId;
    private String descripcion;
    private String nivel;
    private String tipo;

    private List<ResultadoAprendizajeEntity> indicadores;

    public CompetenciaDTO() {
    }

}
