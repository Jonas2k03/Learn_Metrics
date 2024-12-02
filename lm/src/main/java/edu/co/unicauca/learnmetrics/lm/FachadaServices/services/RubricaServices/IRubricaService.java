package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.RubricaServices;

import java.util.List;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.RubricaDTO;

public interface IRubricaService {

	public List<RubricaDTO> findAll();

	public RubricaDTO findById(Long id);

	public RubricaDTO save(RubricaDTO rubrica);

	public RubricaDTO update(Long id, RubricaDTO rubrica);

	public boolean delete(Long id);
}
