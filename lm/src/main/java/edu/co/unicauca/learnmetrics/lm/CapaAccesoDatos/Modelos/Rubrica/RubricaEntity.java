package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RubricaEntity {

    private Long rubricaId;

    private String rubricaNombre;

    private List<CriterioEvaluacionEntity> criterios = new ArrayList<>();

    private Date fechaCreacion;

    private Date fechaModificacion;

    private boolean rubricaEstado;
}