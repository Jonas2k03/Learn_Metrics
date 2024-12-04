package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.RubricaServices;

import java.util.List;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.CriterioEvaluacionDTO;

public interface ICriterioEvaluacionService {

    public List<CriterioEvaluacionDTO> findAll();

    public CriterioEvaluacionDTO findById(Integer id);

    public CriterioEvaluacionDTO save(CriterioEvaluacionDTO cliente);

    public CriterioEvaluacionDTO update(Integer id, CriterioEvaluacionDTO cliente);

    public boolean delete(Integer id);

    public void asociarNivel(Integer idCriterio, Integer idNivel);

}
