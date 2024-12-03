package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.AsignacionEntity.Asig_Comp_Doc_Entity;

import java.util.List;
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


@Getter
@Setter
@Table(name = "TBL_DOCENTE", uniqueConstraints = {
        @UniqueConstraint(columnNames = "DOC_USERNAME"),
        @UniqueConstraint(columnNames = "DOC_CORREO") })
@Entity

public class DocenteEntity {

    @NotBlank
    @Size(max = 120)
    private String password;

    @NotBlank
    @Size(max = 20)
    private String username;

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


    private String doc_titulo;

    @Column(name = "DOC_CORREO", length = 50, nullable = false)
    private String doc_correo;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "oDocenteEntity")
    private List<Asig_Comp_Doc_Entity> asignaciones;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(  name = "user_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    
    public DocenteEntity() {

    }

    public DocenteEntity(String username, String password, TipoDeIdentificacion TipoDeIdentificacion, TipoDeDocente TipoDeDocente, String doc_nombres, String doc_apellidos, String doc_identificacion, String doc_titulo, String doc_correo) {
        this.username = username;
        this.password = password;
        this.TipoDeIdentificacion = TipoDeIdentificacion;
        this.TipoDeDocente = TipoDeDocente;
        this.doc_nombres = doc_nombres;
        this.doc_apellidos = doc_apellidos;
        this.doc_identificacion = doc_identificacion;
        this.doc_titulo = doc_titulo;
        this.doc_correo = doc_correo;
    }       


}