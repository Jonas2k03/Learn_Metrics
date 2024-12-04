package edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.request;

import java.util.List;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.TipoDeDocente;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.TipoDeIdentificacion;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.Asig_Comp_Doc_DTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    
    private Integer doc_id;
    private TipoDeIdentificacion TipoDeIdentificacion;
    private TipoDeDocente TipoDeDocente;
    private String doc_nombres;
    private String doc_apellidos;
    private String doc_identificacion;
    private String doc_titulo;
    private String doc_correo;
    private List<Asig_Comp_Doc_DTO> asignaciones;
    

}
