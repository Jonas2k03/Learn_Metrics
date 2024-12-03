package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.AsignaturaServices;

import java.util.List;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.AsignaturaDTO;

public interface IAsignaturaService {
    public List<AsignaturaDTO> findAll();

    public AsignaturaDTO findById(Integer id);

    public AsignaturaDTO save(AsignaturaDTO asignatura);

    public AsignaturaDTO update(Integer id, AsignaturaDTO asignatura);

    public boolean delete(Integer id);
}
