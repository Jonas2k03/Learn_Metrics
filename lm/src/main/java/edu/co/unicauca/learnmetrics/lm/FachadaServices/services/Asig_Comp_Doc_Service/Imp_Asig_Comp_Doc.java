package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.Asig_Comp_Doc_Service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Asig_Comp_Doc_Entity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.AsignaturaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.CompetenciaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.DocenteEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.Asig_Comp_Doc_Repository;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.Asig_Comp_Doc_DTO;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Imp_Asig_Comp_Doc implements IAsig_Comp_Doc {

    @Autowired
    private Asig_Comp_Doc_Repository serviccioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Asig_Comp_Doc_DTO> findAll() {
        Iterable<Asig_Comp_Doc_Entity> asi_comp_doc = this.serviccioAccesoBaseDatos.findAll();
        List<Asig_Comp_Doc_DTO> asi_comp_docDTO = this.modelMapper.map(asi_comp_doc,
                new TypeToken<List<Asig_Comp_Doc_DTO>>() {
                }.getType());
        return asi_comp_docDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public Asig_Comp_Doc_DTO findByID(Integer asi_comp_doc_ID) {
        Asig_Comp_Doc_Entity asi_comp_doc = this.serviccioAccesoBaseDatos.findById(asi_comp_doc_ID).orElse(null);
        Asig_Comp_Doc_DTO asi_comp_docDTO = this.modelMapper.map(asi_comp_doc, Asig_Comp_Doc_DTO.class);
        return asi_comp_docDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public Asig_Comp_Doc_DTO save(Asig_Comp_Doc_DTO asi_comp_doc) {
        Asig_Comp_Doc_Entity asi_comp_docEntity = this.modelMapper.map(asi_comp_doc, Asig_Comp_Doc_Entity.class);
        Asig_Comp_Doc_Entity asi_comp_docEntitySave = this.serviccioAccesoBaseDatos.save(asi_comp_docEntity);
        Asig_Comp_Doc_DTO asi_comp_docDTO = this.modelMapper.map(asi_comp_docEntitySave, Asig_Comp_Doc_DTO.class);
        return asi_comp_docDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public boolean delete(Integer asi_comp_doc_ID) {
        boolean bandera = false;
        Optional<Asig_Comp_Doc_Entity> optional = this.serviccioAccesoBaseDatos.findById(asi_comp_doc_ID);
        Asig_Comp_Doc_Entity asi_comp_doc = optional.get();

        if (asi_comp_doc != null) {
            this.serviccioAccesoBaseDatos.delete(asi_comp_doc);
            bandera = true;
        }

        return bandera;

    }

    @Override
    public Asig_Comp_Doc_DTO update(Integer id, Asig_Comp_Doc_DTO asi_comp_doc) {
        Optional<Asig_Comp_Doc_Entity> optional = this.serviccioAccesoBaseDatos.findById(id);
        Asig_Comp_Doc_DTO asi_comp_docDTOAct = null;
        Asig_Comp_Doc_Entity objAlmacenado = optional.get();

        if (objAlmacenado != null) {
            objAlmacenado.setAsi_comp_doc_ID(asi_comp_doc.getAsi_comp_doc_ID());
            objAlmacenado.setOCompetenciaEntity(
                    this.modelMapper.map(asi_comp_doc.getOCompetenciaEntity(), CompetenciaEntity.class));
            objAlmacenado
                    .setODocenteEntity(this.modelMapper.map(asi_comp_doc.getODocenteEntity(), DocenteEntity.class));
            objAlmacenado.setOAsignaturaEntity(
                    this.modelMapper.map(asi_comp_doc.getOAsignaturaEntity(), AsignaturaEntity.class));
            Asig_Comp_Doc_Entity objActualizado = this.serviccioAccesoBaseDatos.save(objAlmacenado);
            asi_comp_docDTOAct = this.modelMapper.map(objActualizado, Asig_Comp_Doc_DTO.class);
        }

        return asi_comp_docDTOAct;

    }
}
