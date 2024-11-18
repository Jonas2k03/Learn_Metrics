package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "tbl_nivel")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NivelCriterioEntity {

    public enum Categoria {
        EXCELENTE,
        BUENO,
        REGULAR,
        DEFICIENTE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idNivel;

    @ElementCollection
    @CollectionTable(name = "nivel_categoria", joinColumns = @JoinColumn(name = "nivel_id"))
    @Column(name = "categoria")
    @Enumerated(EnumType.STRING)
    private List<Categoria> categoriaNivel = new ArrayList<>();

    @Column(nullable = false)
    private Double nota;
}