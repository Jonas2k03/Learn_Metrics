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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.ResultadoAprendizajeDTO;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.services.RAServices.IResultadoAprendizajeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
        RequestMethod.PUT })
public class ResultadoAprendizajeRestController {

    @Autowired
    private IResultadoAprendizajeService resultadoAprendizajeService;

    @GetMapping("/ra")
    public ResponseEntity<List<ResultadoAprendizajeDTO>> listarResultadosAprendizaje() {
        List<ResultadoAprendizajeDTO> lista = resultadoAprendizajeService.findAll();
        ResponseEntity<List<ResultadoAprendizajeDTO>> objRespuesta = new ResponseEntity<List<ResultadoAprendizajeDTO>>(
                lista, HttpStatus.OK);
        return objRespuesta;
    }

    @GetMapping("/ra/{id}")
    public ResponseEntity<ResultadoAprendizajeDTO> consultarResultadosAprendizaje(@PathVariable Integer id) {
        ResultadoAprendizajeDTO objResultadoAprendizaje = null;
        objResultadoAprendizaje = resultadoAprendizajeService.findById(id);
        ResponseEntity<ResultadoAprendizajeDTO> objRespuesta = new ResponseEntity<ResultadoAprendizajeDTO>(
                objResultadoAprendizaje,
                HttpStatus.OK);
        return objRespuesta;
    }

    @PostMapping("/ra")
    public ResponseEntity<ResultadoAprendizajeDTO> crearResultadoAprendizaje(
            @RequestBody ResultadoAprendizajeDTO resultadoAprendizaje) {
        ResultadoAprendizajeDTO objResultadoAprendizaje = null;
        objResultadoAprendizaje = resultadoAprendizajeService.save(resultadoAprendizaje);
        ResponseEntity<ResultadoAprendizajeDTO> objRespuesta = new ResponseEntity<ResultadoAprendizajeDTO>(
                objResultadoAprendizaje,
                HttpStatus.CREATED);
        return objRespuesta;
    }

    @PutMapping("/ra")
    public ResponseEntity<ResultadoAprendizajeDTO> actualizarResultadoAprendizaje(
            @RequestBody ResultadoAprendizajeDTO resultadoAprendizaje,
            @RequestParam Integer id) {
        ResultadoAprendizajeDTO objResultadoAprendizaje = resultadoAprendizajeService.update(id, resultadoAprendizaje);
        ResponseEntity<ResultadoAprendizajeDTO> objRespuesta = new ResponseEntity<ResultadoAprendizajeDTO>(
                objResultadoAprendizaje,
                HttpStatus.OK);
        return objRespuesta;
    }

    @DeleteMapping("/ra")
    public ResponseEntity<Boolean> eliminarResultadoAprendizaje(@RequestParam Integer id) {
        Boolean bandera = resultadoAprendizajeService.delete(id);
        ResponseEntity<Boolean> objRespuesta = new ResponseEntity<Boolean>(bandera, HttpStatus.NO_CONTENT);
        return objRespuesta;
    }

    @PostMapping("/ra/asociarRubrica/{idRa}/{idRubrica}")
    public ResponseEntity<ResultadoAprendizajeDTO> asociarRubrica(@PathVariable Integer idRa,
            @PathVariable Integer idRubrica) {
        resultadoAprendizajeService.asociarRubrica(idRa, idRubrica);
        return ResponseEntity.ok().build();
    }

}
