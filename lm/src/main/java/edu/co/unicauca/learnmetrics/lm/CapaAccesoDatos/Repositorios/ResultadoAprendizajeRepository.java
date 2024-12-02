package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.RA.ResultadoAprendizajeEntity;

@Repository
public class ResultadoAprendizajeRepository {

    private int pos;
    private ArrayList<ResultadoAprendizajeEntity> listaDeResultadosAprendizaje;

    public ResultadoAprendizajeRepository() {
        this.listaDeResultadosAprendizaje = new ArrayList<>();
        pos = this.listaDeResultadosAprendizaje.size() + 1;
    }

    public List<ResultadoAprendizajeEntity> findAll() {
        System.out.println("Invocando a listar Resultado De Aprendizaje");
        return this.listaDeResultadosAprendizaje;
    }

    public ResultadoAprendizajeEntity findById(Integer id) {
        System.out.println("Invocando a consultar un Resultado De Aprendizaje");
        ResultadoAprendizajeEntity objresultadoAprendizaje = null;

        for (ResultadoAprendizajeEntity resultadoAprendizaje : listaDeResultadosAprendizaje) {
            if (resultadoAprendizaje.getIdRA() == id) {
                objresultadoAprendizaje = resultadoAprendizaje;
                break;
            }
        }

        return objresultadoAprendizaje;
    }

    public ResultadoAprendizajeEntity save(ResultadoAprendizajeEntity resultadoAprendizaje) {
        System.out.println("Invocando a Crear Resultado De Aprendizaje");
        resultadoAprendizaje.setIdRA(pos);
        ResultadoAprendizajeEntity objresultadoAprendizaje = null;
        if (this.listaDeResultadosAprendizaje.add(resultadoAprendizaje)) {
            objresultadoAprendizaje = resultadoAprendizaje;
            pos++;
        }

        return objresultadoAprendizaje;
    }

    public ResultadoAprendizajeEntity update(Integer id, ResultadoAprendizajeEntity resultadoAprendizaje) {
        System.out.println("Invocando a actualizar un Resultado De Aprendizaje");
        ResultadoAprendizajeEntity objresultadoAprendizaje = null;

        for (int i = 0; i < this.listaDeResultadosAprendizaje.size(); i++) {
            ResultadoAprendizajeEntity resultadoAprendizajeActual = this.listaDeResultadosAprendizaje.get(i);

            if (resultadoAprendizajeActual.getIdRA() == id) {
                resultadoAprendizaje.setIdRA(resultadoAprendizajeActual.getIdRA());
                this.listaDeResultadosAprendizaje.set(i, resultadoAprendizaje);
                objresultadoAprendizaje = resultadoAprendizaje;
                break;
            }
        }

        return objresultadoAprendizaje;
    }

    public boolean delete(Integer id) {
        System.out.println("Invocando a eliminar un Resultado De Aprendizaje");
        boolean bandera = false;

        for (int i = 0; i < this.listaDeResultadosAprendizaje.size(); i++) {
            if (this.listaDeResultadosAprendizaje.get(i).getIdRA() == id) {
                this.listaDeResultadosAprendizaje.remove(i);
                bandera = true;
                break;
            }
        }

        return bandera;
    }

    public boolean existeResultadoAprendizaje(Integer id) {
        System.out.println("Consultando si existe Resultado de Aprendizaje");
        boolean bandera = false;

        for (ResultadoAprendizajeEntity resultadoAprendizaje : listaDeResultadosAprendizaje) {
            if (resultadoAprendizaje.getIdRA() == id) {
                bandera = true;
                break;
            }
        }
        return bandera;
    }

}
