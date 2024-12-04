package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.RubricaServices;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.RA.ResultadoAprendizajeEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica.CriterioEvaluacionEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica.RubricaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.CriterioEvaluacionRepository;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.RubricaRepository;
import edu.co.unicauca.learnmetrics.lm.CapaControladores.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.RubricaDTO;

@Service
public class RubricaServiceImpl implements IRubricaService {

    @Autowired
    private RubricaRepository servicioAccesoBaseDatos;

    @Autowired
    private CriterioEvaluacionRepository criterioEvaluacionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RubricaDTO> findAll() {
        List<RubricaEntity> rubricas = servicioAccesoBaseDatos.findAll();
        List<RubricaDTO> rubricasDTO = this.modelMapper.map(rubricas, new TypeToken<List<RubricaDTO>>() {
        }.getType());
        return rubricasDTO;
    }

    @Override
    public RubricaDTO findById(Integer id) {
        RubricaEntity rubrica = servicioAccesoBaseDatos.findById(id).orElse(null);
        if (rubrica == null) {
            throw new EntidadNoExisteException("Rubrica no existe");
        }
        RubricaDTO rubricaDTO = this.modelMapper.map(rubrica, RubricaDTO.class);
        return rubricaDTO;
    }

    @Override
    public RubricaDTO save(RubricaDTO cliente) {
        RubricaEntity rubricaEntity = this.modelMapper.map(cliente, RubricaEntity.class);
        RubricaEntity rubricaEntitySave = servicioAccesoBaseDatos.save(rubricaEntity);
        RubricaDTO rubricaDTO = this.modelMapper.map(rubricaEntitySave, RubricaDTO.class);
        return rubricaDTO;
    }

    @Override
    public RubricaDTO update(Integer id, RubricaDTO rubrica) {
        Optional<RubricaEntity> rubricaEntity = servicioAccesoBaseDatos.findById(id);

        if (rubricaEntity.isPresent()) {
            RubricaEntity rubricaEntityActualizada = rubricaEntity.get();
            rubricaEntityActualizada.setRubricaNombre(rubrica.getRubricaNombre());
            rubricaEntityActualizada.setRAS(this.modelMapper.map(rubrica.getRAS(), ResultadoAprendizajeEntity.class));
            rubricaEntityActualizada.setCriterios(
                    this.modelMapper.map(rubrica.getCriterios(), new TypeToken<List<CriterioEvaluacionEntity>>() {
                    }.getType()));

            servicioAccesoBaseDatos.save(rubricaEntityActualizada);
            return this.modelMapper.map(rubricaEntityActualizada, RubricaDTO.class);
        } else {
            throw new EntidadNoExisteException("Rubrica no existe");
        }
    }

    @Override
    public boolean delete(Integer id) {
        boolean bandera = false;
        Optional<RubricaEntity> optional = servicioAccesoBaseDatos.findById(id);
        RubricaEntity rubrica = optional.get();

        if (rubrica != null) {
            servicioAccesoBaseDatos.deleteById(id);
            bandera = true;
        }
        return bandera;
    }

    @Override
    public void asociarCriterio(Integer idRubrica, Integer idCriterio) {
        Optional<RubricaEntity> rubricaEntity = servicioAccesoBaseDatos.findById(idRubrica);
        Optional<CriterioEvaluacionEntity> criterioEntity = criterioEvaluacionRepository.findById(idCriterio);

        if (rubricaEntity.isPresent() && criterioEntity.isPresent()) {
            RubricaEntity rubrica = rubricaEntity.get();
            CriterioEvaluacionEntity criterio = criterioEntity.get();

            rubrica.getCriterios().add(criterio);
            criterio.setRubrica(rubrica);
            servicioAccesoBaseDatos.save(rubrica);
        } else {
            throw new EntidadNoExisteException("Rubrica o criterio no existe");
        }
    }

}