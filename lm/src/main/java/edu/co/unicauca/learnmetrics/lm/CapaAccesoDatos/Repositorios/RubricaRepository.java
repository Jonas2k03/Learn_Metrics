package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica.RubricaEntity;

@Repository
public interface RubricaRepository extends JpaRepository<RubricaEntity, Integer> {

}
