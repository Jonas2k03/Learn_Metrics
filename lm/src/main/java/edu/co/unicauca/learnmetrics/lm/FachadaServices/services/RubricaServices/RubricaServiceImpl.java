package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.RubricaServices;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.RubricaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.RubricaRepository;
import edu.co.unicauca.learnmetrics.lm.CapaControladores.controladorExcepciones.excepcionesPropias.EntidadNoExisteException;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.RubricaDTO;

@Service
public class RubricaServiceImpl implements IRubricaService {

    @Autowired
    private RubricaRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;

    public RubricaServiceImpl() {
        // Constructor por defecto necesario para Spring
    }

    @Override
    public List<RubricaDTO> findAll() {
        List<RubricaEntity> rubricasEntity = this.servicioAccesoBaseDatos.findAll();
        List<RubricaDTO> rubricaDTO = this.modelMapper.map(rubricasEntity,
                new TypeToken<List<RubricaDTO>>() {
                }.getType());
        return rubricaDTO;
    }

    @Override
    public RubricaDTO findById(Long id) {
        RubricaEntity objRubricaEntity = this.servicioAccesoBaseDatos.findById(id);
        if (objRubricaEntity == null) {
            throw new EntidadNoExisteException("Error, la rúbrica no existe");
        }
        return this.modelMapper.map(objRubricaEntity, RubricaDTO.class);
    }

    @Override
    public RubricaDTO save(RubricaDTO rubrica) {
        RubricaEntity rubricaEntity = this.modelMapper.map(rubrica, RubricaEntity.class);
        rubricaEntity.setFechaCreacion(new Date());
        rubricaEntity.setFechaModificacion(new Date());
        RubricaEntity objRubricaEntity = this.servicioAccesoBaseDatos.save(rubricaEntity);
        return this.modelMapper.map(objRubricaEntity, RubricaDTO.class);
    }

    @Override
    public RubricaDTO update(Long id, RubricaDTO rubrica) {
        if (!this.servicioAccesoBaseDatos.existeRubrica(id)) {
            throw new EntidadNoExisteException("Error, la rúbrica a actualizar no existe");
        }

        RubricaEntity rubricaEntity = this.modelMapper.map(rubrica, RubricaEntity.class);
        rubricaEntity.setFechaModificacion(new Date());
        RubricaEntity rubricaEntityActualizado = this.servicioAccesoBaseDatos.update(id, rubricaEntity);
        return this.modelMapper.map(rubricaEntityActualizado, RubricaDTO.class);
    }

    @Override
    public boolean delete(Long id) {
        if (!this.servicioAccesoBaseDatos.existeRubrica(id)) {
            throw new EntidadNoExisteException("Error, la rúbrica a eliminar no existe");
        }
        return this.servicioAccesoBaseDatos.delete(id);
    }
}