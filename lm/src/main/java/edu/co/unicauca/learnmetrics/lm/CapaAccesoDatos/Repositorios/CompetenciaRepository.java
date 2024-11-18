package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Competencia.CompetenciaEntity;

@Repository
public class CompetenciaRepository {

    private Integer pos = 103;
    private List<CompetenciaEntity> competencias;

    public CompetenciaRepository() {
        this.competencias = new ArrayList<CompetenciaEntity>();

        cargarCompetencias();

        pos = this.competencias.size() + 1;
    }

    public List<CompetenciaEntity> findAll() {
        System.out.println("findAll competencia");
        return this.competencias;
    }

    public boolean existeCompetencia(Integer id) {
        for (CompetenciaEntity competencia : this.competencias) {
            if (competencia.getCompId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public CompetenciaEntity findById(Integer id) {
        System.out.println("findById competencia");
        for (CompetenciaEntity competencia : this.competencias) {
            if (competencia.getCompId().equals(id)) {
                return competencia;
            }
        }
        return null;
    }

    public CompetenciaEntity save(CompetenciaEntity competencia) {
        System.out.println("save competencia");
        competencia.setCompId(pos);
        this.competencias.add(competencia);
        pos++;
        return competencia;
    }

    public CompetenciaEntity update(Integer id, CompetenciaEntity competencia) {
        System.out.println("update competencia");
        CompetenciaEntity objComp = null;
        for (int i = 0; i < this.competencias.size(); i++) {
            if (this.competencias.get(i).getCompId().equals(id)) {
                this.competencias.set(i, competencia);
                objComp = competencia;
                break;
            }

        }

        return objComp;
    }

    public boolean delete(Integer id) {
        System.out.println("delete competencia");
        boolean result = false;
        for (int i = 0; i < this.competencias.size(); i++) {
            if (this.competencias.get(i).getCompId().equals(id)) {
                this.competencias.remove(i);
                result = true;
                break;
            }
        }
        return result;
    }

    private void cargarCompetencias() {

    }

}
