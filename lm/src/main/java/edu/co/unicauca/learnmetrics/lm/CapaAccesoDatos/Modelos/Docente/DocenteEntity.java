package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class DocenteEntity {

    private Integer doc_id;
    private String doc_tipo_identificacion;
    private String doc_tipo_docente;
    private String doc_nombres;
    private String doc_apellidos;
    private String doc_identificacion;
    private String doc_titulo;
    private String doc_correo;

    public DocenteEntity() {

    }

}