package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.RA.ResultadoAprendizajeEntity;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.ResultadoAprendizajeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_RUBRICA")
public class RubricaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RUB_ID", nullable = false)
    private Integer rubricaId;

    @Column(name = "RUB_NOMBRE", length = 50, nullable = false)
    private String rubricaNombre;

    @ManyToOne
    @JoinColumn(name = "RA_ID")
    @JsonBackReference
    private ResultadoAprendizajeEntity RAS;

    @OneToMany(mappedBy = "rubrica", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<CriterioEvaluacionEntity> criterios;
}