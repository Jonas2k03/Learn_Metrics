package edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.request;

import java.util.Set;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.TipoDeDocente;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.TipoDeIdentificacion;

import jakarta.validation.constraints.*;

public class SignupRequestDTO {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  private Set<String> role;

  @NotBlank
  @Size(min = 6, max = 40)
  private String password;

  @NotBlank
  @Size(max = 50)
  private String nombre;

  @NotBlank
  @Size(max = 50)
  private String apellido;

  @NotBlank
  @Size(max = 20)
  private String identificacion;

  @NotNull
  private TipoDeIdentificacion tipoDeIdentificacion;

  @NotBlank
  @Size(max = 50)
  private String titulo;

  @NotNull
  private TipoDeDocente TipoDeDocente;


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<String> getRole() {
    return this.role;
  }

  public void setRole(Set<String> role) {
    this.role = role;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public void setIdentificacion(String identificacion) {
    this.identificacion = identificacion;
  }

  public TipoDeIdentificacion getTipoDeIdentificacion() {
    return tipoDeIdentificacion;
  }

  public void setTipoDeIdentificacion(TipoDeIdentificacion tipoDeIdentificacion) {
    this.tipoDeIdentificacion = tipoDeIdentificacion;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public TipoDeDocente getTipoDeDocente() {
    return TipoDeDocente;
  }
  
  public void setTipoDeDocente(TipoDeDocente TipoDeDocente) {
    this.TipoDeDocente = TipoDeDocente;
  }


}
