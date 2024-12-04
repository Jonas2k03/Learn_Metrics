package edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO;

import java.util.List;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.TipoDeDocente;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.TipoDeIdentificacion;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class DocenteDTO {
    private Integer doc_id;
    private TipoDeIdentificacion TipoDeIdentificacion;
    private TipoDeDocente TipoDeDocente;
    private String doc_nombres;
    private String doc_apellidos;
    private String doc_identificacion;
    private String doc_titulo;
    private String doc_correo;
    private List<Asig_Comp_Doc_DTO> asignaciones;

    public DocenteDTO() {

    }
    
}
