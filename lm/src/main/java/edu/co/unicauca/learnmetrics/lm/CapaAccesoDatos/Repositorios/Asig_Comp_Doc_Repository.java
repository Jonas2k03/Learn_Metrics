package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.AsignacionEntity.Asig_Comp_Doc_Entity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Asignatura.AsignaturaEntity;

public interface Asig_Comp_Doc_Repository extends JpaRepository<Asig_Comp_Doc_Entity, Integer> {

    List<Asig_Comp_Doc_Entity> findByPeriodo(Integer periodo);

    List<Asig_Comp_Doc_Entity> findByOAsignaturaEntityAndPeriodo(AsignaturaEntity asignatura, Integer periodo);

}
