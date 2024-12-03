package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Asignatura.AsignaturaEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepository extends JpaRepository<AsignaturaEntity, Integer> {

}