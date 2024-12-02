package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "ASI_COMP_DOCENTE")
@Entity
public class Asig_Comp_Doc_Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer asi_comp_doc_ID;

    @ManyToOne
    @JoinColumn(name = "compId")
    private CompetenciaEntity oCompetenciaEntity;

    @ManyToOne
    @JoinColumn(name = "doc_id")
    private DocenteEntity oDocenteEntity;

    @ManyToOne
    @JoinColumn(name = "asigId")
    private AsignaturaEntity oAsignaturaEntity;

}
