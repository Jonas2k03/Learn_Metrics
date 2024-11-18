package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.RubricaServices;

import java.util.List;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.RubricaDTO;

public interface IRubricaService {

	public List<RubricaDTO> findAll();

	public RubricaDTO findById(Long id);

	public RubricaDTO save(RubricaDTO cliente);

	public RubricaDTO update(Long id, RubricaDTO cliente);

	public boolean delete(Long id);
}
