package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.CompetenciaServices;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Competencia.CompetenciaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.CompetenciaRepository;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.CompetenciaDTO;
import edu.co.unicauca.learnmetrics.lm.CapaControladores.controladorExcepciones.excepcionesPropias.*;

@Service
public class CompetenciaServiceImpl implements iCompetenciaService {

    private CompetenciaRepository competenciaRepository;
    private ModelMapper modelMapper;

    public CompetenciaServiceImpl(CompetenciaRepository competenciaRepository, ModelMapper modelMapper) {
        this.competenciaRepository = competenciaRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CompetenciaDTO> findAllComps() {
        List<CompetenciaEntity> competencias = this.competenciaRepository.findAll();
        return modelMapper.map(competencias, new TypeToken<List<CompetenciaDTO>>() {
        }.getType());
    }

    @Override
    public CompetenciaDTO findCompById(Integer id) {

        if (!competenciaRepository.existeCompetencia(id)) {
            EntidadNoExisteException objException = new EntidadNoExisteException(
                    "la competencia con el ID " + id + " no existe");
            throw objException;
        }

        else {
            CompetenciaEntity competencia = this.competenciaRepository.findById(id);
            CompetenciaDTO competenciaDTO = this.modelMapper.map(competencia, CompetenciaDTO.class);
            return competenciaDTO;
        }

    }

    @Override
    public CompetenciaDTO saveComp(CompetenciaDTO competencia) {
        CompetenciaEntity competenciaEntity = modelMapper.map(competencia, CompetenciaEntity.class);
        competenciaEntity = competenciaRepository.save(competenciaEntity);
        return modelMapper.map(competenciaEntity, CompetenciaDTO.class);
    }

    @Override
    public void deleteComp(Integer id) {
        if (!competenciaRepository.existeCompetencia(id)) {
            EntidadNoExisteException objException = new EntidadNoExisteException(
                    "la competencia con el ID " + id + " no existe");
            throw objException;
        }
        competenciaRepository.delete(id);
    }

    @Override
    public CompetenciaDTO updateComp(Integer id, CompetenciaDTO competencia) {
        if (!competenciaRepository.existeCompetencia(id)) {
            EntidadNoExisteException objException = new EntidadNoExisteException(
                    "la competencia con el ID " + id + " no existe");
            throw objException;
        }
        CompetenciaEntity competenciaEntity = modelMapper.map(competencia, CompetenciaEntity.class);
        competenciaEntity = competenciaRepository.update(id, competenciaEntity);
        return modelMapper.map(competenciaEntity, CompetenciaDTO.class);
    }

}
