package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.RAServices;

import java.util.List;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.ResultadoAprendizajeDTO;

public interface IResultadoAprendizajeService {

    public List<ResultadoAprendizajeDTO> findAll();

    public ResultadoAprendizajeDTO findById(Integer id);

    public ResultadoAprendizajeDTO save(ResultadoAprendizajeDTO resultadoAprendizaje);

    public ResultadoAprendizajeDTO update(Integer id, ResultadoAprendizajeDTO resultadoAprendizaje);

    public boolean delete(Integer id);

    public void asociarRubrica(Integer idRa, Integer idRubrica);

}
