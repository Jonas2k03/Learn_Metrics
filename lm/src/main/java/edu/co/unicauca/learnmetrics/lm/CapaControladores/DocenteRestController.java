package edu.co.unicauca.learnmetrics.lm.CapaControladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.DocenteDTO;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.services.DocenteServices.IDocenteService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class DocenteRestController {
    @Autowired
    private IDocenteService docenteService;

    // Listar docente// http://localhost:8080/docentes
    @GetMapping("/docentes")
    public List<DocenteDTO> listarDocentes() {
        return docenteService.findAll();
    }

    // Buscar por id// http://localhost:8080/docentes/1
    @GetMapping("/docentes/{doc_id}")
    public DocenteDTO consulDocente(@PathVariable Integer doc_id) {
        DocenteDTO objDocente = null;
        objDocente = docenteService.findById(doc_id);
        return objDocente;
    }

    @GetMapping("/docentes/consultarDocentes")
    public String consultarDocentesConVariosParametros(@RequestParam String doc_nombres,
            @RequestParam String doc_apellidos) {
        String msg = String.format("buscando un cliente por nombre: %s, apellidos: %s", doc_apellidos, doc_apellidos);
        System.out.println(msg);
        return msg;
    }

    @PostMapping("/docentes")
    public DocenteDTO crearDocente(@RequestBody DocenteDTO docente) {
        DocenteDTO objDocente = null;
        objDocente = docenteService.save(docente);
        return objDocente;
    }

    // Actualizar docente // http://localhost:8080/docentes/4
    @PutMapping("/docentes/{doc_id}")
    public DocenteDTO actualizarDocente(@RequestBody DocenteDTO docente, @PathVariable Integer doc_id) {
        DocenteDTO objDocente = null;
        DocenteDTO docenteActual = docenteService.findById(doc_id);
        if (docenteActual != null) {
            objDocente = docenteService.update(doc_id, docente);
        }

        return objDocente;
    }

    // eliminar // http://localhost:8080/docentes/2
    @DeleteMapping("/{doc_id}")
    public Boolean eliminarDocente(@PathVariable Integer doc_id) {
        boolean bandera = false;
        DocenteDTO docenteActual = docenteService.findById(doc_id);
        if (docenteActual != null) {
            bandera = docenteService.delete(doc_id);
        }
        return bandera;

    }

}
