package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.RubricaServices;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import ch.qos.logback.core.model.Model;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica.CriterioEvaluacionEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica.NivelCriterioEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica.RubricaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.CriterioEvaluacionRepository;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.NivelCriterioRepository;
import edu.co.unicauca.learnmetrics.lm.CapaControladores.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.CriterioEvaluacionDTO;

public class CriterioEvaluacionServiceImp implements ICriterioEvaluacionService {

    @Autowired
    private CriterioEvaluacionRepository criterioEvaluacionRepository;

    @Autowired
    private NivelCriterioRepository nivelCriterioRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CriterioEvaluacionDTO> findAll() {

        List<CriterioEvaluacionDTO> criterios = this.modelMapper.map(criterioEvaluacionRepository.findAll(),
                new TypeToken<List<CriterioEvaluacionDTO>>() {
                }.getType());
        return criterios;

    }

    @Override
    public CriterioEvaluacionDTO findById(Integer id) {

        CriterioEvaluacionEntity criterio = criterioEvaluacionRepository.findById(id).orElse(null);
        if (criterio == null) {
            throw new EntidadNoExisteException("Criterio no existe");
        }
        CriterioEvaluacionDTO criterioDTO = this.modelMapper.map(criterio, CriterioEvaluacionDTO.class);
        return criterioDTO;

    }

    @Override
    public CriterioEvaluacionDTO save(CriterioEvaluacionDTO cliente) {

        CriterioEvaluacionEntity criterioEntity = this.modelMapper.map(cliente, CriterioEvaluacionEntity.class);
        CriterioEvaluacionEntity criterioEntitySave = criterioEvaluacionRepository.save(criterioEntity);
        CriterioEvaluacionDTO criterioDTO = this.modelMapper.map(criterioEntitySave, CriterioEvaluacionDTO.class);
        return criterioDTO;
    }

    @Override
    public CriterioEvaluacionDTO update(Integer id, CriterioEvaluacionDTO cliente) {
        Optional<CriterioEvaluacionEntity> criterioEntity = criterioEvaluacionRepository.findById(id);
        if (criterioEntity.isPresent()) {
            CriterioEvaluacionEntity criterio = criterioEntity.get();
            criterio.setDescripcionCriterio(cliente.getDescripcionCriterio());
            criterio.setNota(cliente.getNota());
            criterio.setPonderacion(cliente.getPonderacion());
            criterio.setRubrica(this.modelMapper.map(cliente.getRubrica(), RubricaEntity.class));
            criterio.setNivelesCriterio(
                    this.modelMapper.map(cliente.getNivelesCriterio(), new TypeToken<List<NivelCriterioEntity>>() {
                    }.getType()));
            criterio = criterioEvaluacionRepository.save(criterio);
            return this.modelMapper.map(criterio, CriterioEvaluacionDTO.class);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Optional<CriterioEvaluacionEntity> optional = criterioEvaluacionRepository.findById(id);
        if (optional.isPresent()) {
            criterioEvaluacionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void asociarNivel(Integer idCriterio, Integer idNivel) {
        Optional<CriterioEvaluacionEntity> criterioEntity = criterioEvaluacionRepository.findById(idCriterio);
        Optional<NivelCriterioEntity> nivelEntity = nivelCriterioRepository.findById(idNivel);

        if (criterioEntity.isPresent() && nivelEntity.isPresent()) {
            CriterioEvaluacionEntity criterio = criterioEntity.get();
            NivelCriterioEntity nivel = nivelEntity.get();

            criterio.getNivelesCriterio().add(nivel);
            nivel.setCriterio(criterio);

            criterioEvaluacionRepository.save(criterio);
        }
    }

}
