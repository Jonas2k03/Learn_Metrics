package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Asignatura.AsignaturaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.RA.ResultadoAprendizajeEntity;

@Repository
public interface ResultadoAprendizajeRepository extends JpaRepository<ResultadoAprendizajeEntity, Integer> {

    List<ResultadoAprendizajeEntity> findByObjAsignaturaAndPeriodo(AsignaturaEntity asignatura, Integer periodo);

}
