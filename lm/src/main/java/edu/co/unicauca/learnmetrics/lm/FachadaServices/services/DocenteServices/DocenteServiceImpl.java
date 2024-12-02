package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.DocenteServices;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.DocenteEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.DocenteRepository;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.DocenteDTO;

@Service
public class DocenteServiceImpl implements IDocenteService {
    private DocenteRepository servicioAccesoBaseDatos;
    private ModelMapper modelMapper;

    public DocenteServiceImpl(DocenteRepository servicioAccesoBaseDatos, ModelMapper modelMapper) {
        this.servicioAccesoBaseDatos = servicioAccesoBaseDatos;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DocenteDTO> findAll() {
        List<DocenteEntity> docentesEntity = this.servicioAccesoBaseDatos.findAll();
        List<DocenteDTO> docentesDTO = this.modelMapper.map(docentesEntity, new TypeToken<List<DocenteDTO>>() {
        }.getType());
        return docentesDTO;

    }

    @Override
    public DocenteDTO save(DocenteDTO docente) {
        DocenteEntity docenteEntity = this.modelMapper.map(docente, DocenteEntity.class);
        DocenteEntity objDocenteEntity = this.servicioAccesoBaseDatos.save(docenteEntity);
        DocenteDTO docenteDTO = this.modelMapper.map(objDocenteEntity, DocenteDTO.class);
        return docenteDTO;
    }

    @Override
    public DocenteDTO update(Integer doc_id, DocenteDTO docente) {
        DocenteEntity docenteEntity = this.modelMapper.map(docente, DocenteEntity.class);
        DocenteEntity docenteEntityActualizado = this.servicioAccesoBaseDatos.update(doc_id, docenteEntity);
        DocenteDTO docenteDTO = this.modelMapper.map(docenteEntityActualizado, DocenteDTO.class);
        return docenteDTO;
    }

    @Override
    public boolean delete(Integer doc_id) {
        return this.servicioAccesoBaseDatos.delete(doc_id);
    }

    @Override
    public DocenteDTO findById(Integer doc_id) {
        DocenteEntity objDocenteEntity = this.servicioAccesoBaseDatos.findById(doc_id);
        DocenteDTO docenteDTO = this.modelMapper.map(objDocenteEntity, DocenteDTO.class);
        return docenteDTO;
    }
}