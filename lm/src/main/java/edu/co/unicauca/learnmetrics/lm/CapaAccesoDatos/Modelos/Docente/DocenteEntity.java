package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente;

import java.util.List;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.AsignacionEntity.Asig_Comp_Doc_Entity;
import jakarta.persistence.Column;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Table(name = "TBL_DOCENTE")
@Entity

public class DocenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOC_ID", length = 50)
    private Integer doc_id;

    @Enumerated(EnumType.STRING)
    @Column(name = "DOC_TIPO_ID", length = 50)
    private enum_tipoID doc_tipo_identificacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "DOC_TIPO_DOCENTE", length = 50)
    private enum_tipoDocente doc_tipo_docente;

    @Column(name = "DOC_NOMBRES", length = 50, nullable = false)
    private String doc_nombres;

    @Column(name = "DOC_APELLIDOS", length = 50, nullable = false)
    private String doc_apellidos;

    @Column(name = "DOC_IDENTIFICACION", nullable = false)
    private String doc_identificacion;

    private String doc_titulo;

    @Column(name = "DOC_CORREO", length = 50, nullable = false)
    private String doc_correo;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "oDocenteEntity")
    private List<Asig_Comp_Doc_Entity> asignaciones;

    public DocenteEntity() {

    }

}