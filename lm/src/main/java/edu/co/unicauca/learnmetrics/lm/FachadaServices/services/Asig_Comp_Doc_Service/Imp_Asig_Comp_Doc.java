package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.Asig_Comp_Doc_Service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.AsignacionEntity.Asig_Comp_Doc_Entity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Asignatura.AsignaturaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Competencia.CompetenciaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.DocenteEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.Asig_Comp_Doc_Repository;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.AsignaturaRepository;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.CompetenciaRepository;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.DocenteRepository;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.Asig_Comp_Doc_DTO;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.AsignaturaDTO;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.CompetenciaDTO;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.DocenteDTO;

import org.springframework.transaction.annotation.Transactional;

@Service
public class Imp_Asig_Comp_Doc implements IAsig_Comp_Doc {

    @Autowired
    private Asig_Comp_Doc_Repository serviccioAccesoBaseDatos;

    @Autowired
    private DocenteRepository docenteRepository;

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    private CompetenciaRepository competenciaRepository;

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
    @Transactional(readOnly = false)
    public Asig_Comp_Doc_DTO update(Integer id, Asig_Comp_Doc_DTO asi_comp_doc) {
        Optional<Asig_Comp_Doc_Entity> optional = this.serviccioAccesoBaseDatos.findById(id);
        Asig_Comp_Doc_DTO asi_comp_docDTOAct = null;
        Asig_Comp_Doc_Entity objAlmacenado = optional.get();

        if (objAlmacenado != null) {
            objAlmacenado.setAsi_comp_doc_ID(asi_comp_doc.getAsi_comp_doc_ID());
            objAlmacenado.setOCompetenciaEntity(
                    modelMapper.map(asi_comp_doc.getOCompetenciaEntity(), CompetenciaEntity.class));
            objAlmacenado.setODocenteEntity(modelMapper.map(asi_comp_doc.getODocenteEntity(), DocenteEntity.class));
            objAlmacenado
                    .setOAsignaturaEntity(modelMapper.map(asi_comp_doc.getOAsignaturaEntity(), AsignaturaEntity.class));
            objAlmacenado = this.serviccioAccesoBaseDatos.save(objAlmacenado);
            asi_comp_docDTOAct = modelMapper.map(objAlmacenado, Asig_Comp_Doc_DTO.class);
        }

        return asi_comp_docDTOAct;

    }

    @Override
    @Transactional(readOnly = false)
    public Asig_Comp_Doc_DTO asociarDocenteAsignatura(Integer idDocente, Integer idAsignatura) {
        Asig_Comp_Doc_DTO asi_comp_docDTO = new Asig_Comp_Doc_DTO();
        Optional<DocenteEntity> docente = docenteRepository.findById(idDocente);
        Optional<AsignaturaEntity> asignatura = asignaturaRepository.findById(idAsignatura);

        if (docente.isPresent() && asignatura.isPresent()) {
            asi_comp_docDTO.setODocenteEntity(modelMapper.map(docente.get(), DocenteDTO.class));
            asi_comp_docDTO.setOAsignaturaEntity(modelMapper.map(asignatura.get(), AsignaturaDTO.class));
            Asig_Comp_Doc_Entity asi_comp_docEntity = modelMapper.map(asi_comp_docDTO, Asig_Comp_Doc_Entity.class);
            asi_comp_docEntity = serviccioAccesoBaseDatos.save(asi_comp_docEntity);
            asi_comp_docDTO = modelMapper.map(asi_comp_docEntity, Asig_Comp_Doc_DTO.class);
        }

        return asi_comp_docDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public Asig_Comp_Doc_DTO asociarCompetenciaAsignatura(Integer idCompetencia, Integer idAsignatura) {
        Asig_Comp_Doc_DTO asi_comp_docDTO = new Asig_Comp_Doc_DTO();
        Optional<CompetenciaEntity> competencia = competenciaRepository.findById(idCompetencia);
        Optional<AsignaturaEntity> asignatura = asignaturaRepository.findById(idAsignatura);

        if (competencia.isPresent() && asignatura.isPresent()) {
            asi_comp_docDTO.setOCompetenciaEntity(modelMapper.map(competencia.get(), CompetenciaDTO.class));
            asi_comp_docDTO.setOAsignaturaEntity(modelMapper.map(asignatura.get(), AsignaturaDTO.class));
            Asig_Comp_Doc_Entity asi_comp_docEntity = modelMapper.map(asi_comp_docDTO, Asig_Comp_Doc_Entity.class);
            asi_comp_docEntity = serviccioAccesoBaseDatos.save(asi_comp_docEntity);
            asi_comp_docDTO = modelMapper.map(asi_comp_docEntity, Asig_Comp_Doc_DTO.class);
        }

        return asi_comp_docDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public Asig_Comp_Doc_DTO asociarAsig_Comp_Doc_DTO(Integer idAsignatura, Integer idCompetencia, Integer idDocente) {
        Asig_Comp_Doc_DTO asi_comp_docDTO = new Asig_Comp_Doc_DTO();
        Optional<CompetenciaEntity> competencia = competenciaRepository.findById(idCompetencia);
        Optional<AsignaturaEntity> asignatura = asignaturaRepository.findById(idAsignatura);
        Optional<DocenteEntity> docente = docenteRepository.findById(idDocente);

        if (competencia.isPresent() && asignatura.isPresent() && docente.isPresent()) {
            asi_comp_docDTO.setOCompetenciaEntity(modelMapper.map(competencia.get(), CompetenciaDTO.class));
            asi_comp_docDTO.setOAsignaturaEntity(modelMapper.map(asignatura.get(), AsignaturaDTO.class));
            asi_comp_docDTO.setODocenteEntity(modelMapper.map(docente.get(), DocenteDTO.class));
            Asig_Comp_Doc_Entity asi_comp_docEntity = modelMapper.map(asi_comp_docDTO, Asig_Comp_Doc_Entity.class);
            asi_comp_docEntity = serviccioAccesoBaseDatos.save(asi_comp_docEntity);
            asi_comp_docDTO = modelMapper.map(asi_comp_docEntity, Asig_Comp_Doc_DTO.class);
        }

        return asi_comp_docDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public Asig_Comp_Doc_DTO desasociarDocenteAsignatura(Integer idDocente, Integer idAsignatura) {
        Asig_Comp_Doc_DTO asi_comp_docDTO = new Asig_Comp_Doc_DTO();
        Optional<DocenteEntity> docente = docenteRepository.findById(idDocente);
        Optional<AsignaturaEntity> asignatura = asignaturaRepository.findById(idAsignatura);

        if (docente.isPresent() && asignatura.isPresent()) {
            asi_comp_docDTO.setODocenteEntity(modelMapper.map(docente.get(), DocenteDTO.class));
            asi_comp_docDTO.setOAsignaturaEntity(modelMapper.map(asignatura.get(), AsignaturaDTO.class));
            Asig_Comp_Doc_Entity asi_comp_docEntity = modelMapper.map(asi_comp_docDTO, Asig_Comp_Doc_Entity.class);
            serviccioAccesoBaseDatos.delete(asi_comp_docEntity);
        }

        return asi_comp_docDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public Asig_Comp_Doc_DTO desasociarCompetenciaAsignatura(Integer idCompetencia, Integer idAsignatura) {
        Asig_Comp_Doc_DTO asi_comp_docDTO = new Asig_Comp_Doc_DTO();
        Optional<CompetenciaEntity> competencia = competenciaRepository.findById(idCompetencia);
        Optional<AsignaturaEntity> asignatura = asignaturaRepository.findById(idAsignatura);

        if (competencia.isPresent() && asignatura.isPresent()) {
            asi_comp_docDTO.setOCompetenciaEntity(modelMapper.map(competencia.get(), CompetenciaDTO.class));
            asi_comp_docDTO.setOAsignaturaEntity(modelMapper.map(asignatura.get(), AsignaturaDTO.class));
            Asig_Comp_Doc_Entity asi_comp_docEntity = modelMapper.map(asi_comp_docDTO, Asig_Comp_Doc_Entity.class);
            serviccioAccesoBaseDatos.delete(asi_comp_docEntity);
        }

        return asi_comp_docDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public Asig_Comp_Doc_DTO desasociarAsig_Comp_Doc_DTO(Integer idAsignatura, Integer idCompetencia,
            Integer idDocente) {
        Asig_Comp_Doc_DTO asi_comp_docDTO = new Asig_Comp_Doc_DTO();
        Optional<CompetenciaEntity> competencia = competenciaRepository.findById(idCompetencia);
        Optional<AsignaturaEntity> asignatura = asignaturaRepository.findById(idAsignatura);
        Optional<DocenteEntity> docente = docenteRepository.findById(idDocente);

        if (competencia.isPresent() && asignatura.isPresent() && docente.isPresent()) {
            asi_comp_docDTO.setOCompetenciaEntity(modelMapper.map(competencia.get(), CompetenciaDTO.class));
            asi_comp_docDTO.setOAsignaturaEntity(modelMapper.map(asignatura.get(), AsignaturaDTO.class));
            asi_comp_docDTO.setODocenteEntity(modelMapper.map(docente.get(), DocenteDTO.class));
            Asig_Comp_Doc_Entity asi_comp_docEntity = modelMapper.map(asi_comp_docDTO, Asig_Comp_Doc_Entity.class);
            serviccioAccesoBaseDatos.delete(asi_comp_docEntity);
        }

        return asi_comp_docDTO;
    }
}
