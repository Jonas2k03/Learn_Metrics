package edu.co.unicauca.learnmetrics.lm.CapaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.services.Asig_Comp_Doc_Service.IAsig_Comp_Doc;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.Asig_Comp_Doc_DTO;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class Asig_Com_Doc_RestController {

    @Autowired
    private IAsig_Comp_Doc asig_comp_docService;

    @GetMapping("/asig_comp_doc")
    public List<Asig_Comp_Doc_DTO> listarAsig_Comp_Doc() {
        return asig_comp_docService.findAll();
    }

    @GetMapping("/asig_comp_doc/{id}")
    public Asig_Comp_Doc_DTO consultarAsig_Comp_Doc(Integer id) {
        Asig_Comp_Doc_DTO objAsig_Comp_Doc = null;
        objAsig_Comp_Doc = asig_comp_docService.findByID(id);
        return objAsig_Comp_Doc;
    }

    @PostMapping("/asig_comp_doc")
    public Asig_Comp_Doc_DTO crearAsig_Comp_Doc(Asig_Comp_Doc_DTO asig_comp_doc) {
        Asig_Comp_Doc_DTO objAsig_Comp_Doc = null;
        objAsig_Comp_Doc = asig_comp_docService.save(asig_comp_doc);
        return objAsig_Comp_Doc;
    }

    @PostMapping("/asociarDocAsig/{idAsignatura}/{idDocente}")
    public Asig_Comp_Doc_DTO asociarDocenteAsignatura(
            @PathVariable("idAsignatura") Integer idDocente,
            @PathVariable("idDocente") Integer idAsignatura) {
        return asig_comp_docService.asociarDocenteAsignatura(idDocente, idAsignatura);
    }

    @PostMapping("/asociarCompAsig/{idCompetencia}/{idAsignatura}")
    public Asig_Comp_Doc_DTO asociarCompetenciaAsignatura(
            @PathVariable("idCompetencia") Integer idCompetencia,
            @PathVariable("idAsignatura") Integer idAsignatura) {
        return asig_comp_docService.asociarCompetenciaAsignatura(idCompetencia, idAsignatura);
    }

    @PostMapping("/asociarAsigCompDoc/{idAsignatura}/{idCompetencia}/{idDocente}")
    public Asig_Comp_Doc_DTO asociarAsig_Comp_Doc_DTO(
            @PathVariable("idAsignatura") Integer idAsignatura,
            @PathVariable("idCompetencia") Integer idCompetencia,
            @PathVariable("idDocente") Integer idDocente) {
        return asig_comp_docService.asociarAsig_Comp_Doc_DTO(idAsignatura, idCompetencia, idDocente);
    }

    @DeleteMapping("/desasociarDocAsig/{idDocente}/{idAsignatura}")
    public boolean desasociarDocenteAsignatura(
            @PathVariable("idDocente") Integer idDocente,
            @PathVariable("idAsignatura") Integer idAsignatura) {
        return asig_comp_docService.desasociarDocenteAsignatura(idDocente, idAsignatura);
    }

    @DeleteMapping("/desasociarCompAsig/{idCompetencia}/{idAsignatura}")
    public boolean desasociarCompetenciaAsignatura(
            @PathVariable("idCompetencia") Integer idCompetencia,
            @PathVariable("idAsignatura") Integer idAsignatura) {
        return asig_comp_docService.desasociarCompetenciaAsignatura(idCompetencia, idAsignatura);
    }

    @DeleteMapping("/desasociar/{idAsignatura}/{idCompetencia}/{idDocente}")
    public boolean desasociarAsig_Comp_Doc_DTO(
            @PathVariable("idAsignatura") Integer idAsignatura,
            @PathVariable("idCompetencia") Integer idCompetencia,
            @PathVariable("idDocente") Integer idDocente) {
        return asig_comp_docService.desasociarAsig_Comp_Doc_DTO(idAsignatura, idCompetencia, idDocente);
    }

}
