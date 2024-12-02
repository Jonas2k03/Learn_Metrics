package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Setter
public class NivelCriterioEntity {

    public enum Categoria {
        EXCELENTE,
        BUENO,
        REGULAR,
        DEFICIENTE
    }

    private Integer idNivel;
    private Categoria categoriaNivel;
    private Double nota;
}