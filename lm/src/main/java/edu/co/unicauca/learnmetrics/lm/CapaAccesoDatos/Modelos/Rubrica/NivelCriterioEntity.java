package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "tbl_nivel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NivelCriterioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NIVEL_ID", nullable = false)
    private Integer idNivel;

    @Enumerated(EnumType.STRING)
    @Column(name = "NIVEL_CATEGORIA", nullable = false)
    private enum_categoriaRUB categoriaNivel;

    @Column(name = "NIVEL_NOTA", nullable = false)
    private Double nota;

    @ManyToMany(mappedBy = "nivelesCriterio")
    private List<CriterioEvaluacionEntity> nivelesCriterio;
}