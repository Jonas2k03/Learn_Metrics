package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos;

import java.util.List;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "TBL_ASIGNATURA")
@Entity
public class AsignaturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ASIG_ID")
    private Integer asigId;

    @Column(name = "ASIG_NOMBRE", length = 50, nullable = false)
    private String nombre;

    @Column(name = "ASIG_CREDITOS", length = 50, nullable = false)
    private Integer creditos;

    @Column(name = "ASIG_OBJETIVOS", length = 250, nullable = false)
    private String objetivos;

    @Column(name = "ASIG_SEMESTRE", nullable = false)
    private Integer semestre;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "oAsignaturaEntity")
    private List<Asig_Comp_Doc_Entity> asignaciones;

    public AsignaturaEntity() {
    }

}
