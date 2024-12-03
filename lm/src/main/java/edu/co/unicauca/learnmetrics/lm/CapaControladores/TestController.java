package edu.co.unicauca.learnmetrics.lm.CapaControladores;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
  @GetMapping("/all")
  public String allAccess() {
    return "Contenido publico";
  }

  @GetMapping("/docente")
  @PreAuthorize("hasRole('DOCENTE') or hasRole('COORDINADOR')")
  public String userAccess() {
    return "Contenido privado. Datos retornados para el api de usuarios.";
  }

  @GetMapping("/coordinador")
  @PreAuthorize("hasRole('COORDINADOR')")
  public String moderatorAccess() {
    return "Contenido privado. Datos retornados para el api de moderador.";
  }

}
