package edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Asig_Comp_Doc_DTO {

    private Integer asi_comp_doc_ID;
    private CompetenciaDTO oCompetenciaEntity;
    private DocenteDTO oDocenteEntity;
    private AsignaturaDTO oAsignaturaEntity;

    public Asig_Comp_Doc_DTO() {
    }

}
