package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Asignatura.AsignaturaEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

import java.util.List;

@Repository
public class AsignaturaRepository {
    private int pos;
    private ArrayList<AsignaturaEntity> listaDeAsignaturas;

    public AsignaturaRepository() {
        this.listaDeAsignaturas = new ArrayList<AsignaturaEntity>();
        cargarAsignaturas();
        pos = this.listaDeAsignaturas.size() + 1;
    }

    public List<AsignaturaEntity> findAll() {
        System.out.println("Invocando Lista de asignaturas");
        return this.listaDeAsignaturas;

    }

    public AsignaturaEntity findById(Integer id) {
        System.out.println("Invocando asignatura con id: " + id);
        AsignaturaEntity objAsignatura = null;

        for (AsignaturaEntity asignatura : listaDeAsignaturas) {
            if (asignatura.getAsigId() == id) {
                objAsignatura = asignatura;
            }
        }
        return objAsignatura;
    }

    public AsignaturaEntity save(AsignaturaEntity asignatura) {
        System.out.println("Invocando a almacenar asignatura");
        asignatura.setAsigId(pos);
        AsignaturaEntity objAsignatura = null;
        if (this.listaDeAsignaturas.add(asignatura)) {
            objAsignatura = asignatura;
            pos++;
        }
        return objAsignatura;

    }

    public AsignaturaEntity update(Integer id, AsignaturaEntity asignatura) {
        System.out.println("Invocando a actualizar asignatura");
        AsignaturaEntity objAsignatura = null;

        for (int i = 0; i < listaDeAsignaturas.size(); i++) {
            if (this.listaDeAsignaturas.get(i).getAsigId() == id) {
                this.listaDeAsignaturas.set(i, asignatura);
                objAsignatura = asignatura;
                break;
            }
        }
        return objAsignatura;
    }

    public boolean delete(Integer id) {
        System.out.println("Invocando a eliminar asignatura");
        boolean bandera = false;

        for (int i = 0; i < this.listaDeAsignaturas.size(); i++) {
            if (this.listaDeAsignaturas.get(i).getAsigId() == id) {
                this.listaDeAsignaturas.remove(i);
                bandera = true;
                break;
            }
        }
        return bandera;
    }

    private void cargarAsignaturas() {
        AsignaturaEntity asignatura1 = new AsignaturaEntity(); // CARGAAAAAAAAAAR
        this.listaDeAsignaturas.add(asignatura1);

    }

}