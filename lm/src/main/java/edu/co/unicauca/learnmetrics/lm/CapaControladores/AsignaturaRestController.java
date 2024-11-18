package edu.co.unicauca.learnmetrics.lm.CapaControladores;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.AsignaturaDTO;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.services.AsignaturaServices.IAsignaturaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
        RequestMethod.DELETE })
public class AsignaturaRestController {
    @Autowired
    private IAsignaturaService asignaturaService;

    @GetMapping("/asignaturas")
    public List<AsignaturaDTO> listarAsignaturas() {

        return asignaturaService.findAll();
    }

    @GetMapping("/asignaturas/{id}")
    public AsignaturaDTO consultarAsignatura(@PathVariable Integer id) {
        AsignaturaDTO objAsignatura = null;
        objAsignatura = asignaturaService.findById(id);
        return objAsignatura;
    }

    @GetMapping("/Asignaturas2")
    public AsignaturaDTO consultarAsignatura2(@RequestParam Integer id) {
        AsignaturaDTO objAsignatura = null;
        objAsignatura = asignaturaService.findById(id);
        return objAsignatura;
    }

    @GetMapping("consultarAsignaturas")
    public String consultarAsignaturaConVariosParametros(@RequestParam String nombre) {
        String msg = String.format("Buscando asignatura por nombre: %s", nombre);
        System.out.println(msg);
        return msg;
    }

    @PostMapping("/asignaturas")
    public AsignaturaDTO crearAsignatura(@RequestBody AsignaturaDTO asignatura) {
        AsignaturaDTO objAsignatura = null;
        objAsignatura = asignaturaService.save(asignatura);
        return objAsignatura;
    }

    @PutMapping("/asignaturas/{id}")
    public AsignaturaDTO actualizarAsignatura(@RequestBody AsignaturaDTO asignatura, @PathVariable Integer id) {
        AsignaturaDTO objAsignatura = null;
        AsignaturaDTO asignaturaActual = asignaturaService.findById(id);

        if (asignaturaActual != null) {
            objAsignatura = asignaturaService.update(id, asignatura);

        }
        return objAsignatura;
    }

    @DeleteMapping("/asignaturas/{id}")
    public Boolean eliminarAsignatura(@PathVariable Integer id) {

        Boolean bandera = false;
        AsignaturaDTO asignaturaActual = asignaturaService.findById(id);
        if (asignaturaActual != null) {

            bandera = asignaturaService.delete(id);
        }
        return bandera;
    }

    @GetMapping("/asignaturas/listarCabeceras")
    public void listarCabeceras(@RequestHeader Map<String, String> headers) {
        System.out.println("cabeceras");
        headers.forEach((key, value) -> {
            System.out.println(String.format("Cabecera '%s' = %s", key, value));
        });
    }

}
