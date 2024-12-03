package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.DocenteServices;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import javax.print.Doc;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.DocenteEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.DocenteRepository;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.DocenteDTO;

@Service
public class DocenteServiceImpl implements IDocenteService {
    @Autowired
    private DocenteRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<DocenteDTO> findAll() {
        Iterable<DocenteEntity> docentes = this.servicioAccesoBaseDatos.findAll();
        List<DocenteDTO> docentesDTO = this.modelMapper.map(docentes,
                new TypeToken<List<DocenteDTO>>() {
                }.getType());
        return docentesDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public DocenteDTO findById(Integer doc_id) {
        DocenteEntity docente = this.servicioAccesoBaseDatos.findById(doc_id).orElse(null);
        DocenteDTO docenteDTO = this.modelMapper.map(docente, DocenteDTO.class);
        return docenteDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public DocenteDTO save(DocenteDTO docente) {
        DocenteEntity docenteEntity = this.modelMapper.map(docente, DocenteEntity.class);
        DocenteEntity docenteEntitySave = this.servicioAccesoBaseDatos.save(docenteEntity);
        DocenteDTO docenteDTO = this.modelMapper.map(docenteEntitySave, DocenteDTO.class);
        return docenteDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public DocenteDTO update(Integer doc_id, DocenteDTO docente) {
        Optional<DocenteEntity> optional = this.servicioAccesoBaseDatos.findById(doc_id);

        if (optional.isPresent()) {
            DocenteEntity docenteEntity = optional.get();

            docenteEntity.setDoc_nombres(docente.getDoc_nombres());
            docenteEntity.setDoc_apellidos(docente.getDoc_apellidos());
            docenteEntity.setDoc_correo(docente.getDoc_correo());
            docenteEntity.setDoc_tipo_identificacion(docente.getDoc_tipo_identificacion());
            docenteEntity.setDoc_identificacion(docente.getDoc_identificacion());
            docenteEntity.setDoc_tipo_docente(docente.getDoc_tipo_docente());
            docenteEntity.setDoc_titulo(docente.getDoc_titulo());

            docenteEntity = this.servicioAccesoBaseDatos.save(docenteEntity);
            return this.modelMapper.map(docenteEntity, DocenteDTO.class);

        }
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean delete(Integer doc_id) {
        boolean bandera = false;
        Optional<DocenteEntity> optional = this.servicioAccesoBaseDatos.findById(doc_id);
        DocenteEntity docente = optional.get();

        if (docente != null) {
            this.servicioAccesoBaseDatos.delete(docente);
            bandera = true;
        }

        return bandera;
    }

}