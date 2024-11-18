package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Competencia;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.RA.ResultadoAprendizajeEntity;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class CompetenciaEntity {

    Integer compId;
    String descripcion;
    String nivel;
    String tipo;
    private List<ResultadoAprendizajeEntity> indicadores;

    public CompetenciaEntity() {
    }

}
