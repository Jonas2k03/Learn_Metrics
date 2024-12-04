package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Competencia;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.AsignacionEntity.Asig_Comp_Doc_Entity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.RA.ResultadoAprendizajeEntity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_COMPETENCIA")
public class CompetenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMP_ID")
    private Integer compId;

    @Column(name = "COMP_DESCRIPCION", length = 250, nullable = false)
    private String descripcion;

    @Column(name = "COMP_TIPO", length = 50)
    private String tipo;

    @Column(name = "COMP_NIVEL", length = 50)
    private String nivel;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "objCompetencia")
    @JsonManagedReference
    private List<ResultadoAprendizajeEntity> RA = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "oCompetenciaEntity", cascade = CascadeType.ALL)
    private List<Asig_Comp_Doc_Entity> asignaciones = new ArrayList<>();

}
