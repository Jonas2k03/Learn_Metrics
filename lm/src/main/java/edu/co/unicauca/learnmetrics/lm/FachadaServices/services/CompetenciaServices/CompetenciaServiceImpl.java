package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.CompetenciaServices;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Competencia.CompetenciaEntity;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.CompetenciaRepository;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.CompetenciaDTO;
import edu.co.unicauca.learnmetrics.lm.CapaControladores.controladorExcepciones.excepcionesPropias.*;
import java.util.List;
import java.util.stream.Collectors;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompetenciaServiceImpl implements iCompetenciaService {

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CompetenciaDTO> findAllComps() {
        List<CompetenciaEntity> competencias = (List<CompetenciaEntity>) competenciaRepository.findAll();
        return competencias.stream()
                .map(competencia -> modelMapper.map(competencia, CompetenciaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CompetenciaDTO findCompById(Integer id) {
        CompetenciaEntity competencia = competenciaRepository.findById(id)
                .orElseThrow(() -> new EntidadNoExisteException("La competencia con el ID " + id + " no existe"));
        return modelMapper.map(competencia, CompetenciaDTO.class);
    }

    @Override
    public CompetenciaDTO saveComp(CompetenciaDTO competencia) {
        CompetenciaEntity competenciaEntity = modelMapper.map(competencia, CompetenciaEntity.class);
        competenciaEntity = competenciaRepository.save(competenciaEntity);
        return modelMapper.map(competenciaEntity, CompetenciaDTO.class);
    }

    @Override
    public void deleteComp(Integer id) {
        if (!competenciaRepository.existsById(id)) {
            throw new EntidadNoExisteException("La competencia con el ID " + id + " no existe");
        }
        competenciaRepository.deleteById(id);
    }

    @Override
    public CompetenciaDTO updateComp(Integer id, CompetenciaDTO competencia) {
        Optional<CompetenciaEntity> competenciaEntity = competenciaRepository.findById(id);
        if (!competenciaEntity.isPresent()) {
            throw new EntidadNoExisteException("La competencia con el ID " + id + " no existe");
        }
        CompetenciaEntity competenciaEntityUpdate = modelMapper.map(competencia, CompetenciaEntity.class);
        competenciaEntityUpdate = competenciaRepository.save(competenciaEntityUpdate);
        return modelMapper.map(competenciaEntityUpdate, CompetenciaDTO.class);

    }
}
