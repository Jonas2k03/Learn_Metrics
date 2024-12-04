package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.RubricaServices;

import java.util.List;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.RubricaDTO;

public interface IRubricaService {

	public List<RubricaDTO> findAll();

	public RubricaDTO findById(Integer id);

	public RubricaDTO save(RubricaDTO cliente);

	public RubricaDTO update(Integer id, RubricaDTO cliente);

	public boolean delete(Integer id);

	public void asociarCriterio(Integer idRubrica, Integer idCriterio);
}
