package edu.co.unicauca.learnmetrics.lm.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.TipoDeDocente;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.TipoDeIdentificacion;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.DocenteEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsImpl implements UserDetails {
  private static final Integer serialVersionUID = 1;

  private Integer id;

  private String username;

  private String email;

  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  private String nombre;
  private String apellido;
  private String identificacion;
  private TipoDeIdentificacion tipoDeIdentificacion;
  private String titulo;
  private TipoDeDocente tipoDeDocente;

  public UserDetailsImpl(Integer id, String username, String email, String password,
      Collection<? extends GrantedAuthority> authorities, String nombre, String apellido, String identificacion, TipoDeIdentificacion tipoDeIdentificacion, String titulo, TipoDeDocente tipoDeDocente) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.authorities = authorities;
    this.nombre = nombre;
    this.apellido = apellido;
    this.identificacion = identificacion;
    this.tipoDeIdentificacion = tipoDeIdentificacion;
    this.titulo = titulo;
    this.tipoDeDocente = tipoDeDocente;

  }

  public static UserDetailsImpl build(DocenteEntity user) {
    List<GrantedAuthority> authorities = user.getRoles().stream()
        .map(role -> new SimpleGrantedAuthority(role.getName().name()))
        .collect(Collectors.toList());

    return new UserDetailsImpl(
        user.getDoc_id(), 
        user.getUsername(), 
        user.getEmail(),
        user.getPassword(), 
        authorities,
        user.getDoc_nombres(),
        user.getDoc_apellidos(),
        user.getDoc_identificacion(),
        user.getTipoDeIdentificacion(),
        user.getDoc_titulo(),

        user.getTipoDeDocente());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  public Integer getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public String getIdentificacion() {
    return identificacion;
  }

  public TipoDeIdentificacion getTipoDeIdentificacion() {
    return tipoDeIdentificacion;
  }

  public String getTitulo() {
    return titulo;
  }

  public TipoDeDocente getTipoDeDocente() {
    return tipoDeDocente;
  }


  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    UserDetailsImpl user = (UserDetailsImpl) o;
    return Objects.equals(id, user.id);
  }
}
