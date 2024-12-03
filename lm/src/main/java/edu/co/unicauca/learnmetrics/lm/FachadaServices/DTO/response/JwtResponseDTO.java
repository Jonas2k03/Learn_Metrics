package edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.response;

import java.util.List;

public class JwtResponseDTO {
  private String token;
  private String type = "Bearer";
  private Integer id;
  private String username;
  private String email;
  private List<String> roles;
  private String nombre;
  private String apellido;
  private String identificacion;
  private String tipoDeIdentificacion;
  private String titulo;
  private String tipoDeDocente;

  public JwtResponseDTO(String accessToken, Integer id, String username, String email, List<String> roles, String nombre, String apellido, String identificacion, String tipoDeIdentificacion, String titulo, String tipoDeDocente) {
    this.token = accessToken;
    this.id = id;
    this.username = username;
    this.email = email;
    this.roles = roles;
    this.nombre = nombre;
    this.apellido = apellido;
    this.identificacion = identificacion;
    this.tipoDeIdentificacion = tipoDeIdentificacion;
    this.titulo = titulo;
    this.tipoDeDocente = tipoDeDocente;

  }

  public String getAccessToken() {
    return token;
  }

  public void setAccessToken(String accessToken) {
    this.token = accessToken;
  }

  public String getTokenType() {
    return type;
  }

  public void setTokenType(String tokenType) {
    this.type = tokenType;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
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

  public String getTipoDeIdentificacion() {
    return tipoDeIdentificacion;
  }

  public void setTipoDeIdentificacion(String tipoDeIdentificacion) {
    this.tipoDeIdentificacion = tipoDeIdentificacion;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getTipoDeDocente() {
    return tipoDeDocente;
  }

  public void setTipoDeDocente(String tipoDeDocente) {
    this.tipoDeDocente = tipoDeDocente;
  }
}
