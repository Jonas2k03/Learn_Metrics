package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.RA;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Competencia.CompetenciaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica.RubricaEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

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

    @ManyToMany
    @JoinTable(name = "TBL_RA_RUBRICA", joinColumns = @JoinColumn(name = "RA_ID"), inverseJoinColumns = @JoinColumn(name = "RUB_ID"))
    private List<RubricaEntity> rubricas;

    @Enumerated(EnumType.STRING)
    @Column(name = "RA_TIPO")
    private TipoRA tipoRA;

    @ManyToOne
    @JoinColumn(name = "COMP_ID")
    private CompetenciaEntity objCompetencia;

    public ResultadoAprendizajeEntity() {
    }
}
