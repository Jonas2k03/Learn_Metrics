package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Competencia.CompetenciaEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciaRepository extends JpaRepository<CompetenciaEntity, Integer> {

}
