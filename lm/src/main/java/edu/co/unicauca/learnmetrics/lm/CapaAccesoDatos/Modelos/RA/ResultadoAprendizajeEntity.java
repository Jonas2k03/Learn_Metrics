package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.RA;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica.RubricaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ResultadoAprendizajeEntity {

    private int idRA;
    private String descripcionRA;
    private List<RubricaEntity> rubricas;
    private TipoRA tipoRA;

    public ResultadoAprendizajeEntity() {
    }
}
