package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.DocenteEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.TipoDeDocente;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.TipoDeIdentificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocenteRepository extends JpaRepository<DocenteEntity, Integer> {

    Optional<DocenteEntity> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Modifying
    @Query("update DocenteEntity d set d.doc_id = :doc_id, d.TipoDeIdentificacion = :tipoDeIdentificacion, d.TipoDeDocente = :tipoDeDocente, d.doc_nombres = :doc_nombres, d.doc_apellidos = :doc_apellidos, d.doc_identificacion = :doc_identificacion, d.doc_titulo = :doc_titulo, d.email = :email where d.doc_id = :id")
    void updateDocente(@Param("doc_id") Integer doc_id, @Param("tipoDeIdentificacion") TipoDeIdentificacion tipoDeIdentificacion, @Param("tipoDeDocente") TipoDeDocente tipoDeDocente, @Param("doc_nombres") String doc_nombres, @Param("doc_apellidos") String doc_apellidos, @Param("doc_identificacion") String doc_identificacion, @Param("doc_titulo") String doc_titulo, @Param("email") String email, @Param("id") Integer id);
}