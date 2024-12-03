package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.AsignacionEntity.Asig_Comp_Doc_Entity;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.NaturalId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.AsignacionEntity.Asig_Comp_Doc_Entity;



@Getter
@Setter
@Entity
@Table(name = "TBL_DOCENTE", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email") })
public class DocenteEntity {

    @NotBlank
    @Size(max = 120)
    private String password;

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 20)
    private String email;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DOC_ID", length = 50)
    private Integer doc_id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "DOC_TIPO_ID", length = 50)
    private TipoDeIdentificacion TipoDeIdentificacion;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "DOC_TIPO_DOCENTE", length = 50)
    private TipoDeDocente TipoDeDocente;


    @Column(name = "DOC_NOMBRES", length = 50, nullable = false)
    private String doc_nombres;


    @Column(name = "DOC_APELLIDOS", length = 50, nullable = false)
    private String doc_apellidos;


    @Column(name = "DOC_IDENTIFICACION", nullable = false)
    private String doc_identificacion;

    @NotBlank
    @Size(max = 50)
    private String doc_titulo;

    /* 
    @NotBlank
    @Email
    @Column(name = "DOC_CORREO", length = 50, nullable = false)
    private String doc_correo;*/


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "oDocenteEntity", cascade = CascadeType.ALL)
    private List<Asig_Comp_Doc_Entity> asignaciones = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "DOC_ID"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    
    public DocenteEntity() {

    }

    public DocenteEntity(String username, String email, String password, String nombre, String apellido, String identificacion, TipoDeIdentificacion tipoDeIdentificacion, String titulo, TipoDeDocente tipoDeDocente) {
        this.username = username;
        this.email = email;
        //this.doc_correo = email;
        this.password = password;
        this.doc_nombres = nombre;
        this.doc_apellidos = apellido;
        this.doc_identificacion = identificacion;
        this.TipoDeIdentificacion = tipoDeIdentificacion;
        this.doc_titulo = titulo;
        this.TipoDeDocente = tipoDeDocente;
      }


}