package edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO;

import java.util.List;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.AsignacionEntity.Asig_Comp_Doc_Entity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.RA.ResultadoAprendizajeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompetenciaDTO {

    private Integer compId;
    private String descripcion;
    private String tipo;
    private String nivel;
    private List<ResultadoAprendizajeEntity> RA;
    private List<Asig_Comp_Doc_Entity> asignaciones;

    public CompetenciaDTO() {
    }

}
