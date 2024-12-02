package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos;

import java.util.List;
import javax.persistence.*;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
@AllArgsConstructor
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
    private List<ResultadoAprendizajeEntity> RA;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "oCompetenciaEntity")
    private List<Asig_Comp_Doc_Entity> asignaciones;

    // Constructor vacío necesario para JPA
    public CompetenciaEntity() {
    }
}
