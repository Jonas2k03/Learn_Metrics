package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.AsignaturaServices;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Asignatura.AsignaturaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.AsignaturaRepository;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.AsignaturaDTO;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService {

    @Autowired
    private AsignaturaRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<AsignaturaDTO> findAll() {
        Iterable<AsignaturaEntity> asignaturas = this.servicioAccesoBaseDatos.findAll();
        List<AsignaturaDTO> asignaturasDTO = this.modelMapper.map(asignaturas,
                new TypeToken<List<AsignaturaDTO>>() {
                }.getType());
        return asignaturasDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public AsignaturaDTO findById(Integer id) {
        Optional<AsignaturaEntity> optional = this.servicioAccesoBaseDatos.findById(id);
        AsignaturaEntity asignatura = optional.get();

        AsignaturaDTO asignaturaDTO = modelMapper.map(asignatura, AsignaturaDTO.class);
        return asignaturaDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public AsignaturaDTO save(AsignaturaDTO asignatura) {
        AsignaturaEntity asignaturaEntity = modelMapper.map(asignatura, AsignaturaEntity.class);
        asignaturaEntity = servicioAccesoBaseDatos.save(asignaturaEntity);
        return modelMapper.map(asignaturaEntity, AsignaturaDTO.class);
    }

    @Override
    @Transactional(readOnly = false)
    public AsignaturaDTO update(Integer id, AsignaturaDTO asignatura) {
        Optional<AsignaturaEntity> optional = servicioAccesoBaseDatos.findById(id);
        if (optional.isPresent()) {
            AsignaturaEntity asignaturaEntity = optional.get();

            asignaturaEntity.setNombre(asignatura.getNombre());
            asignaturaEntity.setCreditos(asignatura.getCreditos());
            asignaturaEntity.setSemestre(asignatura.getSemestre());
            asignaturaEntity.setObjetivos(asignatura.getObjetivos());

            asignaturaEntity = servicioAccesoBaseDatos.save(asignaturaEntity);
            return modelMapper.map(asignaturaEntity, AsignaturaDTO.class);

        }

        return null;

    }

    @Override
    @Transactional(readOnly = false)
    public boolean delete(Integer id) {
        boolean bandera = false;
        Optional<AsignaturaEntity> optional = servicioAccesoBaseDatos.findById(id);
        AsignaturaEntity asignatura = optional.get();

        if (asignatura != null) {
            servicioAccesoBaseDatos.deleteById(id);
            bandera = true;
        }
        return bandera;
    }

}