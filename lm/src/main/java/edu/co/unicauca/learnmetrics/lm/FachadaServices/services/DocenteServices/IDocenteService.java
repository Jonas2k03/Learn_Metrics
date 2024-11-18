package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.DocenteServices;

import java.util.List;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.DocenteDTO;

public interface IDocenteService {
    public List<DocenteDTO> findAll();

    public DocenteDTO findById(Integer doc_id);

    public DocenteDTO save(DocenteDTO docente);

    public DocenteDTO update(Integer doc_id, DocenteDTO docente);

    public boolean delete(Integer doc_id);

}
