package edu.co.unicauca.learnmetrics.lm.CapaControladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.RubricaDTO;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.services.RubricaServices.IRubricaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:51011", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class RubricaRestController {

    @Autowired
    private IRubricaService rubricaService;

    @GetMapping("/rubricas")
    public ResponseEntity<List<RubricaDTO>> listarRubrica() {
        List<RubricaDTO> lista = rubricaService.findAll();
        ResponseEntity<List<RubricaDTO>> objRespuesta = new ResponseEntity<List<RubricaDTO>>(lista, HttpStatus.OK);
        return objRespuesta;
    }

    @GetMapping("/rubricas/{id}")
    public ResponseEntity<RubricaDTO> consultarRubrica(@PathVariable Long id) {
        RubricaDTO objRubrica = rubricaService.findById(id);
        ResponseEntity<RubricaDTO> objRespuesta = new ResponseEntity<RubricaDTO>(objRubrica, HttpStatus.OK);
        return objRespuesta;
    }

    @PostMapping("/rubricas")
    public ResponseEntity<RubricaDTO> crearRubrica(@RequestBody RubricaDTO rubrica) {
        RubricaDTO objRubrica = rubricaService.save(rubrica);
        ResponseEntity<RubricaDTO> objRespuesta = new ResponseEntity<RubricaDTO>(objRubrica, HttpStatus.CREATED);
        return objRespuesta;
    }

    @PutMapping()
    public ResponseEntity<RubricaDTO> actualizarRubrica(@RequestBody RubricaDTO rubrica, @PathVariable Long id) {
        RubricaDTO objRubrica = rubricaService.update(id, rubrica);
        ResponseEntity<RubricaDTO> objRespuesta = new ResponseEntity<RubricaDTO>(objRubrica, HttpStatus.OK);
        return objRespuesta;
    }

    @DeleteMapping()
    public ResponseEntity<Boolean> eliminarRubrica(@PathVariable Long id) {
        Boolean bandera = rubricaService.delete(id);
        ResponseEntity<Boolean> objRespuesta = new ResponseEntity<Boolean>(bandera, HttpStatus.NO_CONTENT);
        return objRespuesta;
    }
}
