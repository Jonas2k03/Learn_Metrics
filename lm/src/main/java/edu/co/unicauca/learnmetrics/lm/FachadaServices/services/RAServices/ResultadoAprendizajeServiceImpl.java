package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.RAServices;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.ResultadoAprendizajeEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.ResultadoAprendizajeRepository;
import edu.co.unicauca.learnmetrics.lm.CapaControladores.controladorExcepciones.excepcionesPropias.*;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.ResultadoAprendizajeDTO;

@Service
public class ResultadoAprendizajeServiceImpl implements IResultadoAprendizajeService {

    private ResultadoAprendizajeRepository servicioAccesoBaseDatos;
    private ModelMapper modelMapper;

    public ResultadoAprendizajeServiceImpl(ResultadoAprendizajeRepository servicioAccesoBaseDatos,
            ModelMapper modelMapper) {
        this.servicioAccesoBaseDatos = servicioAccesoBaseDatos;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ResultadoAprendizajeDTO> findAll() {
        List<ResultadoAprendizajeEntity> resultadoAprendizajeEntity = this.servicioAccesoBaseDatos.findAll();
        List<ResultadoAprendizajeDTO> resultadoAprendizajeDTO = this.modelMapper.map(resultadoAprendizajeEntity,
                new TypeToken<List<ResultadoAprendizajeDTO>>() {
                }.getType());
        return resultadoAprendizajeDTO;
    }

    @Override
    public ResultadoAprendizajeDTO findById(Integer id) {
        ResultadoAprendizajeDTO resultadoAprendizajeDTO = null;
        if (this.servicioAccesoBaseDatos.existeResultadoAprendizaje(id)) {
            ResultadoAprendizajeEntity objResultadoAprendizajeEntity = this.servicioAccesoBaseDatos.findById(id);
            resultadoAprendizajeDTO = this.modelMapper.map(objResultadoAprendizajeEntity,
                    ResultadoAprendizajeDTO.class);
        } else {
            throw new EntidadNoExisteException(
                    "No existe la solicitud buscada");
        }

        return resultadoAprendizajeDTO;
    }

    @Override
    public ResultadoAprendizajeDTO save(ResultadoAprendizajeDTO resultadoAprendizaje) {
        ResultadoAprendizajeDTO resultadoAprendizajeDTO = null;

        ResultadoAprendizajeEntity resultadoAprendizajeEntity = this.modelMapper.map(resultadoAprendizaje,
                ResultadoAprendizajeEntity.class);
        ResultadoAprendizajeEntity objSolicitudEntity = this.servicioAccesoBaseDatos.save(resultadoAprendizajeEntity);
        resultadoAprendizajeDTO = this.modelMapper.map(objSolicitudEntity, ResultadoAprendizajeDTO.class);

        return resultadoAprendizajeDTO;
    }

    @Override
    public ResultadoAprendizajeDTO update(Integer id, ResultadoAprendizajeDTO resultadoAprendizaje) {

        ResultadoAprendizajeDTO resultadoAprendizajeDTO = null;

        ResultadoAprendizajeEntity resultadoAprendizajeEntity = this.modelMapper.map(resultadoAprendizaje,
                ResultadoAprendizajeEntity.class);
        ResultadoAprendizajeEntity resultadoAprendizajeEntityActualizada = this.servicioAccesoBaseDatos.update(id,
                resultadoAprendizajeEntity);
        resultadoAprendizajeDTO = this.modelMapper.map(resultadoAprendizajeEntityActualizada,
                ResultadoAprendizajeDTO.class);

        return resultadoAprendizajeDTO;
    }

    @Override
    public boolean delete(Integer id) {
        boolean bandera = false;
        if (this.servicioAccesoBaseDatos.existeResultadoAprendizaje(id) == true) {
            bandera = this.servicioAccesoBaseDatos.delete(id);
        } else {
            EntidadNoExisteException objException = new EntidadNoExisteException(
                    "El Resultado de Aprendizaje no Existe");
            throw objException;
        }
        return bandera;
    }
}
