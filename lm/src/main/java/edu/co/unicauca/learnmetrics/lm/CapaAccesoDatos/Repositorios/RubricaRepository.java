package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica.RubricaEntity;

@Repository
public class RubricaRepository {
    private Long pos;
    private ArrayList<RubricaEntity> listaRubricas;

    public RubricaRepository() {
        this.listaRubricas = new ArrayList<RubricaEntity>();
        pos = (long) this.listaRubricas.size() + 1;
    }

    public boolean existeRubrica(Long id) {
        System.out.println("Consultar si existe rubrica");
        boolean bandera = false;

        for (RubricaEntity rubrica : listaRubricas) {
            if (rubrica.getRubricaId() == id) {
                bandera = true;
                break;
            }
        }
        return bandera;
    }

    public List<RubricaEntity> findAll() {
        System.out.println("Invocando a listaRubricas");
        return this.listaRubricas;
    }

    public RubricaEntity findById(Long id) {
        System.out.println("Invocando a consultar rubrica");
        RubricaEntity objRubrica = null;

        for (RubricaEntity rubrica : listaRubricas) {
            if (rubrica.getRubricaId() == id) {
                objRubrica = rubrica;
                break;
            }
        }
        return objRubrica;
    }

    public RubricaEntity save(RubricaEntity rubrica) {
        System.out.println("Invocando a almacenar rubrica");
        rubrica.setRubricaId(pos);
        RubricaEntity objRubrica = null;
        if (this.listaRubricas.add(rubrica)) {
            objRubrica = rubrica;
            pos++;
        }
        return objRubrica;
    }

    public RubricaEntity update(Long id, RubricaEntity rubrica) {
        System.out.println("Invocando a actualizar rubrica");
        RubricaEntity objRubrica = null;

        for (int i = 0; i < this.listaRubricas.size(); i++) {
            if (this.listaRubricas.get(i).getRubricaId() == id) {
                objRubrica = this.listaRubricas.get(i);
                objRubrica.setRubricaNombre(rubrica.getRubricaNombre());
                objRubrica.setCriterios(rubrica.getCriterios());
                objRubrica.setFechaModificacion(new Date());
                objRubrica.setRubricaEstado(rubrica.isRubricaEstado());
                this.listaRubricas.set(i, objRubrica);
                break;
            }
        }
        return objRubrica;
    }

    public boolean delete(Long id) {
        System.out.println("Invocando a elminar una rubrica");
        boolean bandera = false;

        for (int i = 0; i < this.listaRubricas.size(); i++) {
            if (this.listaRubricas.get(i).getRubricaId() == id) {
                this.listaRubricas.remove(i);
                bandera = true;
                break;
            }
        }
        return bandera;
    }
}
