package edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RubricaDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long rubricaId;
    @Column(name = "nombre", unique = true, nullable = false)
    private String rubricaNombre;
    // private ResultadoAprendizaje resAprendizaje;
    // private List<CriterioEvaluacionEntity> criterios;
    private Date fechaCreacion;
    private Date fechaModificacion;
    @Column(name = "estado")
    private boolean rubricaEstado;
}
