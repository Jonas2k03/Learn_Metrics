package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.RA;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Competencia.CompetenciaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica.RubricaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "TBL_RA")
public class ResultadoAprendizajeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RA_ID")
    private int idRA;

    @Column(name = "RA_DESCRIPCION", length = 250, nullable = false)
    private String descripcionRA;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "RAS")
    @JsonManagedReference
    private List<RubricaEntity> rubricas = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "RA_TIPO")
    private TipoRA tipoRA;

    @ManyToOne
    @JoinColumn(name = "COMP_ID")
    @JsonBackReference
    private CompetenciaEntity objCompetencia;

    public ResultadoAprendizajeEntity() {
    }
}
