package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.AsignaturaServices;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.AsignaturaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.AsignaturaRepository;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.AsignaturaDTO;

@Service
public class AsignaturaServiceImpl implements IAsignaturaService {

    @Autowired
    private AsignaturaRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;

    public AsignaturaServiceImpl(AsignaturaRepository servicioAccesoBaseDatos, ModelMapper modelMapper) {
        this.servicioAccesoBaseDatos = servicioAccesoBaseDatos;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AsignaturaDTO> findAll() {
        List<AsignaturaEntity> asignaturasEntity = this.servicioAccesoBaseDatos.findAll();
        List<AsignaturaDTO> asignaturasDTO = this.modelMapper.map(asignaturasEntity,
                new TypeToken<List<AsignaturaDTO>>() {
                }.getType());
        return asignaturasDTO;

    }

    @Override
    public AsignaturaDTO save(AsignaturaDTO asignatura) {
        AsignaturaEntity asignaturasEntity = modelMapper.map(asignatura, AsignaturaEntity.class);
        AsignaturaEntity objAsignaturaEntity = this.servicioAccesoBaseDatos.save(asignaturasEntity);
        AsignaturaDTO AsignaturaDTO = this.modelMapper.map(objAsignaturaEntity, AsignaturaDTO.class);
        return AsignaturaDTO;
    }

    @Override
    public AsignaturaDTO findById(Integer id) {
        AsignaturaEntity asignaturaEntity = servicioAccesoBaseDatos.findById(id);
        if (asignaturaEntity != null) {
            return modelMapper.map(asignaturaEntity, AsignaturaDTO.class);
        }
        return null;

    }

    @Override
    public AsignaturaDTO update(Integer id, AsignaturaDTO asignaturaDTO) {
        AsignaturaEntity asignaturasEntity = modelMapper.map(asignaturaDTO, AsignaturaEntity.class);
        AsignaturaEntity updatedAsignatura = servicioAccesoBaseDatos.update(id, asignaturasEntity);
        if (updatedAsignatura != null) {
            return modelMapper.map(updatedAsignatura, AsignaturaDTO.class);
        }
        return asignaturaDTO; // Throw exception
    }

    @Override
    public boolean delete(Integer id) {
        if (this.servicioAccesoBaseDatos.findById(id) == null) {
            return false;
        }
        return servicioAccesoBaseDatos.delete(id);
    }

    @Override
    public AsignaturaDTO asociarCompetencia(Integer asigId, Integer compId) {
        return null;
        // Implementar lógica para asociar competencia
    }

}