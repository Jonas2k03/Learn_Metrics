package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.DocenteEntity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class DocenteRepository {
    private int pos;
    private ArrayList<DocenteEntity> listaDeDocentes;

    public DocenteRepository() {

        this.listaDeDocentes = new ArrayList<DocenteEntity>();
        cargarDocentes();
        pos = this.listaDeDocentes.size() + 1;
    }

    public List<DocenteEntity> findAll() {
        System.out.println("Invocando a listar docentes");
        return this.listaDeDocentes;
    }

    public DocenteEntity findById(Integer doc_id) {
        System.out.println("Invocando a consultar un Docente");
        DocenteEntity objDocente = null;
        for (DocenteEntity docente : listaDeDocentes) {
            if (docente.getDoc_id() == doc_id) {
                objDocente = docente;
                break;
            }
        }
        return objDocente;
    }

    public DocenteEntity save(DocenteEntity docente) {
        System.out.println("Invocando almacenar docente");
        docente.setDoc_id(pos);
        DocenteEntity objDocente = null;
        if (this.listaDeDocentes.add(docente)) {
            objDocente = docente;
            pos++;
        }

        return objDocente;

    }

    public DocenteEntity update(Integer doc_id, DocenteEntity docente) {
        System.out.println("Invocando a actualizar un Docente");
        DocenteEntity objDocente = null;
        for (int i = 0; i < this.listaDeDocentes.size(); i++) {
            if (this.listaDeDocentes.get(i).getDoc_id() == doc_id) {
                this.listaDeDocentes.set(i, docente);
                objDocente = docente;
                break;
            }
        }
        return objDocente;
    }

    public boolean delete(Integer doc_id) {
        System.out.println("Invocando a eliminar un Docente");
        boolean bandera = false;
        for (int i = 0; i < this.listaDeDocentes.size(); i++) {
            if (this.listaDeDocentes.get(i).getDoc_id() == doc_id) {
                this.listaDeDocentes.remove(i);
                bandera = true;
                break;
            }
        }
        return bandera;
    }

    private void cargarDocentes() {

    }

}
