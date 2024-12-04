package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.RubricaServices;

import java.util.List;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.NivelCriterioDTO;

public interface INivelCriterioService {

    public List<NivelCriterioDTO> findAll();

    public NivelCriterioDTO findById(Integer id);

    public NivelCriterioDTO save(NivelCriterioDTO nivelCriterio);

    public NivelCriterioDTO update(Integer id, NivelCriterioDTO nivelCriterio);

    public boolean delete(Integer id);

}
