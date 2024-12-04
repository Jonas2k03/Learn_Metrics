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

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.CompetenciaDTO;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.services.CompetenciaServices.iCompetenciaService;

@RestController
@RequestMapping("/api/competencias")
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class CompetenciaRestController {

    @Autowired
    private iCompetenciaService competenciaService;

    @GetMapping
    public ResponseEntity<List<CompetenciaDTO>> findAllComps() {
        List<CompetenciaDTO> competencias = competenciaService.findAllComps();
        ResponseEntity<List<CompetenciaDTO>> response = new ResponseEntity<>(competencias, HttpStatus.OK);
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetenciaDTO> findCompById(@PathVariable Integer id) {
        return ResponseEntity.ok(competenciaService.findCompById(id));
    }

    @PostMapping
    public ResponseEntity<CompetenciaDTO> saveComp(@RequestBody CompetenciaDTO competencia) {
        return new ResponseEntity<>(competenciaService.saveComp(competencia), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComp(@PathVariable Integer id) {
        competenciaService.deleteComp(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompetenciaDTO> updateComp(@PathVariable Integer id,
            @RequestBody CompetenciaDTO competencia) {
        return ResponseEntity.ok(competenciaService.updateComp(id, competencia));
    }

    @PostMapping("/asociarRa/{id}/{idRa}")
    public ResponseEntity<CompetenciaDTO> asociarRa(@PathVariable Integer id, @PathVariable Integer idRa) {
        competenciaService.asociarRa(id, idRa);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/desasociarRa/{id}/{idRa}")
    public ResponseEntity<CompetenciaDTO> desasociarRa(@PathVariable Integer id, @PathVariable Integer idRa) {
        competenciaService.desasociarRa(id, idRa);
        return ResponseEntity.ok().build();
    }

}
