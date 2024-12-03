package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.DocenteEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepository extends JpaRepository<DocenteEntity, Integer> {

}
