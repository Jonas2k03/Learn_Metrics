package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.AsignacionEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Asignatura.AsignaturaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Competencia.CompetenciaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.DocenteEntity;
import jakarta.persistence.*;
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
    @JoinColumn(name = "compId", nullable = true)
    @JsonIgnore
    private CompetenciaEntity oCompetenciaEntity;

    @ManyToOne
    @JoinColumn(name = "doc_id", nullable = true)
    @JsonIgnore
    private DocenteEntity oDocenteEntity;

    @ManyToOne
    @JoinColumn(name = "asigId", nullable = true)
    @JsonIgnore
    private AsignaturaEntity oAsignaturaEntity;

    public Asig_Comp_Doc_Entity() {
    }

}
