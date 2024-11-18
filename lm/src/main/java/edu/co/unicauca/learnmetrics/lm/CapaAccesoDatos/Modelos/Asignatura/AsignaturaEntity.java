package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Asignatura;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Competencia.CompetenciaEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AsignaturaEntity {
    private Integer asigId;
    private String nombre;
    private Integer creditos;
    private String objetivos;
    private Integer semestre;
    private List<CompetenciaEntity> competencias;

    public AsignaturaEntity() {
    }

}
