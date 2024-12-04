package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.CompetenciaServices;

import java.util.List;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.CompetenciaDTO;

public interface iCompetenciaService {

    public List<CompetenciaDTO> findAllComps();

    public CompetenciaDTO findCompById(Integer id);

    public CompetenciaDTO saveComp(CompetenciaDTO competencia);

    public boolean deleteComp(Integer id);

    public CompetenciaDTO updateComp(Integer id, CompetenciaDTO competencia);

    public void asociarRa(Integer id, Integer idRa);

    public void desasociarRa(Integer id, Integer idRa);

}