package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.RAServices;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Competencia.CompetenciaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.RA.ResultadoAprendizajeEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Rubrica.RubricaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.CompetenciaRepository;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.ResultadoAprendizajeRepository;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.RubricaRepository;
import edu.co.unicauca.learnmetrics.lm.CapaControladores.controladorExcepciones.excepcionesPropias.*;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.ResultadoAprendizajeDTO;

@Service
public class ResultadoAprendizajeServiceImpl implements IResultadoAprendizajeService {

    @Autowired
    private ResultadoAprendizajeRepository servicioAccesoBaseDatos;

    @Autowired
    private RubricaRepository rubricaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ResultadoAprendizajeDTO> findAll() {
        List<ResultadoAprendizajeEntity> resultadosAprendizaje = servicioAccesoBaseDatos.findAll();
        List<ResultadoAprendizajeDTO> resultadosAprendizajeDTO = this.modelMapper.map(resultadosAprendizaje,
                new TypeToken<List<ResultadoAprendizajeDTO>>() {
                }.getType());
        return resultadosAprendizajeDTO;
    }

    @Override
    public ResultadoAprendizajeDTO findById(Integer id) {
        ResultadoAprendizajeEntity resultadoAprendizaje = servicioAccesoBaseDatos.findById(id).orElse(null);
        ResultadoAprendizajeDTO resultadoAprendizajeDTO = this.modelMapper.map(resultadoAprendizaje,
                ResultadoAprendizajeDTO.class);
        return resultadoAprendizajeDTO;

    }

    @Override
    public ResultadoAprendizajeDTO save(ResultadoAprendizajeDTO resultadoAprendizaje) {
        ResultadoAprendizajeEntity resultadoAprendizajeEntity = this.modelMapper.map(resultadoAprendizaje,
                ResultadoAprendizajeEntity.class);
        ResultadoAprendizajeEntity resultadoAprendizajeEntitySave = servicioAccesoBaseDatos
                .save(resultadoAprendizajeEntity);
        ResultadoAprendizajeDTO resultadoAprendizajeDTO = this.modelMapper.map(resultadoAprendizajeEntitySave,
                ResultadoAprendizajeDTO.class);
        return resultadoAprendizajeDTO;
    }

    @Override
    public ResultadoAprendizajeDTO update(Integer id, ResultadoAprendizajeDTO resultadoAprendizaje) {
        Optional<ResultadoAprendizajeEntity> optional = servicioAccesoBaseDatos.findById(id);

        if (optional.isPresent()) {
            ResultadoAprendizajeEntity resultadoAprendizajeEntity = optional.get();

            resultadoAprendizajeEntity.setDescripcionRA(resultadoAprendizaje.getDescripcionRA());
            resultadoAprendizajeEntity.setTipoRA(resultadoAprendizaje.getTipoRA());

            resultadoAprendizajeEntity = servicioAccesoBaseDatos.save(resultadoAprendizajeEntity);
            return modelMapper.map(resultadoAprendizajeEntity, ResultadoAprendizajeDTO.class);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        boolean bandera = false;
        Optional<ResultadoAprendizajeEntity> optional = servicioAccesoBaseDatos.findById(id);
        ResultadoAprendizajeEntity resultadoAprendizaje = optional.get();

        if (resultadoAprendizaje != null) {
            servicioAccesoBaseDatos.deleteById(id);
            bandera = true;
        }

        return bandera;
    }

    @Override
    public void asociarRubrica(Integer idRa, Integer idRubrica) {
        Optional<ResultadoAprendizajeEntity> optionalRa = servicioAccesoBaseDatos.findById(idRa);
        Optional<RubricaEntity> optionalRubrica = rubricaRepository.findById(idRubrica);

        if (optionalRa.isPresent() && optionalRubrica.isPresent()) {
            ResultadoAprendizajeEntity ra = optionalRa.get();
            RubricaEntity rubrica = optionalRubrica.get();
            ra.getRubricas().add(rubrica);
            rubrica.setRAS(ra);
            servicioAccesoBaseDatos.save(ra);
        } else {
            throw new EntidadNoExisteException("No se encontró el resultado de aprendizaje");
        }
    }

}
