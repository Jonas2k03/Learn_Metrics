package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.RubricaServices;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica.CriterioEvaluacionEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica.NivelCriterioEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.NivelCriterioRepository;
import edu.co.unicauca.learnmetrics.lm.CapaControladores.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.NivelCriterioDTO;

public class NivelCriterioServiceImp implements INivelCriterioService {

    @Autowired
    public NivelCriterioRepository nivelCriterioRepository;

    @Autowired
    public ModelMapper modelMapper;

    @Override
    public List<NivelCriterioDTO> findAll() {

        List<NivelCriterioEntity> niveles = nivelCriterioRepository.findAll();
        List<NivelCriterioDTO> nivelesDTO = this.modelMapper.map(niveles, new TypeToken<List<NivelCriterioDTO>>() {
        }.getType());

        return nivelesDTO;

    }

    @Override
    public NivelCriterioDTO findById(Integer id) {

        NivelCriterioEntity nivel = nivelCriterioRepository.findById(id).orElse(null);
        if (nivel == null) {
            throw new EntidadNoExisteException("Nivel no existe");
        }
        NivelCriterioDTO nivelDTO = this.modelMapper.map(nivel, NivelCriterioDTO.class);
        return nivelDTO;
    }

    @Override
    public NivelCriterioDTO save(NivelCriterioDTO nivelCriterio) {

        NivelCriterioEntity nivelEntity = this.modelMapper.map(nivelCriterio, NivelCriterioEntity.class);
        NivelCriterioEntity nivelEntitySave = nivelCriterioRepository.save(nivelEntity);
        NivelCriterioDTO nivelDTO = this.modelMapper.map(nivelEntitySave, NivelCriterioDTO.class);
        return nivelDTO;
    }

    @Override
    public NivelCriterioDTO update(Integer id, NivelCriterioDTO nivelCriterio) {
        Optional<NivelCriterioEntity> nivelEntity = nivelCriterioRepository.findById(id);

        if (nivelEntity.isPresent()) {
            NivelCriterioEntity nivel = nivelEntity.get();
            nivel.setDescripcion(nivelCriterio.getDescripcion());
            nivel.setCategoriaNivel(nivelCriterio.getCategoriaNivel());
            nivel.setCriterio(modelMapper.map(nivelCriterio.getCriterio(), CriterioEvaluacionEntity.class));
            nivel = nivelCriterioRepository.save(nivel);
            return modelMapper.map(nivel, NivelCriterioDTO.class);
        }

        else {
            throw new EntidadNoExisteException("Nivel no existe");
        }

    }

    @Override
    public boolean delete(Integer id) {
        boolean bandera = false;
        Optional<NivelCriterioEntity> optional = nivelCriterioRepository.findById(id);
        NivelCriterioEntity nivel = optional.get();

        if (nivel != null) {
            nivelCriterioRepository.deleteById(id);
            bandera = true;
        }
        return bandera;
    }

}
