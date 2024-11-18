package edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaDTO {
    private Integer asigId;
    private String nombre;
    private Integer creditos;
    private String objetivos;
    private Integer semestre;
    private List<CompetenciaDTO> competencias;
}
