package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.CompetenciaServices;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.AsignacionEntity.Asig_Comp_Doc_Entity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Asignatura.AsignaturaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Competencia.CompetenciaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.RA.ResultadoAprendizajeEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.Asig_Comp_Doc_Repository;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.AsignaturaRepository;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.CompetenciaRepository;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.ResultadoAprendizajeRepository;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.CompetenciaDTO;

import org.springframework.transaction.annotation.Transactional;
import edu.co.unicauca.learnmetrics.lm.CapaControladores.controladorExcepciones.excepcionesPropias.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CompetenciaServiceImpl implements iCompetenciaService {

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Autowired
    private Asig_Comp_Doc_Repository asig_Comp_Doc_Repository;

    @Autowired
    private ResultadoAprendizajeRepository resultadoAprendizajeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CompetenciaDTO> findAllComps() {
        Iterable<CompetenciaEntity> competencias = competenciaRepository.findAll();
        List<CompetenciaDTO> competenciasDTO = this.modelMapper.map(competencias,
                new TypeToken<List<CompetenciaDTO>>() {
                }.getType());
        return competenciasDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public CompetenciaDTO findCompById(Integer id) {
        Optional<CompetenciaEntity> optional = competenciaRepository.findById(id);
        CompetenciaEntity comp = optional.get();

        CompetenciaDTO competenciaDTO = modelMapper.map(comp, CompetenciaDTO.class);
        return competenciaDTO;
    }

    @Override
    @Transactional(readOnly = false)
    public CompetenciaDTO saveComp(CompetenciaDTO competencia) {
        CompetenciaEntity competenciaEntity = modelMapper.map(competencia, CompetenciaEntity.class);
        competenciaEntity = competenciaRepository.save(competenciaEntity);
        return modelMapper.map(competenciaEntity, CompetenciaDTO.class);
    }

    @Override
    public boolean deleteComp(Integer id) {
        boolean bandera = false;
        Optional<CompetenciaEntity> optional = competenciaRepository.findById(id);
        CompetenciaEntity competencia = optional.get();

        if (competencia != null) {
            competenciaRepository.deleteById(id);
            bandera = true;
        }
        return bandera;

    }

    @Override
    public CompetenciaDTO updateComp(Integer id, CompetenciaDTO competencia) {
        // Obtén el objeto existente si está presente
        Optional<CompetenciaEntity> optional = competenciaRepository.findById(id);

        if (optional.isPresent()) {
            CompetenciaEntity objAlmacenado = optional.get();

            // Actualiza los valores con los datos del DTO recibido
            objAlmacenado.setDescripcion(competencia.getDescripcion());
            objAlmacenado.setTipo(competencia.getTipo());
            objAlmacenado.setNivel(competencia.getNivel());

            // Guarda el objeto actualizado en la base de datos
            CompetenciaEntity objActualizado = competenciaRepository.save(objAlmacenado);

            // Devuelve el DTO del objeto actualizado
            return modelMapper.map(objActualizado, CompetenciaDTO.class);
        }

        // Si no se encuentra la entidad, devuelve null o lanza una excepción según tu
        // lógica de negocio
        return null;
    }

    @Override
    public void asociarRa(Integer id, Integer idRa) {
        // Buscar la competencia por su id
        Optional<CompetenciaEntity> optionalCompetencia = competenciaRepository.findById(id);
        // Buscar el resultado de aprendizaje por su id
        Optional<ResultadoAprendizajeEntity> optionalRa = resultadoAprendizajeRepository.findById(idRa);

        // Verificar que ambos objetos existan
        if (optionalCompetencia.isPresent() && optionalRa.isPresent()) {
            CompetenciaEntity competencia = optionalCompetencia.get();
            ResultadoAprendizajeEntity ra = optionalRa.get();

            // Asociar el resultado de aprendizaje a la competencia
            competencia.getRA().add(ra); // Añadir RA a la lista de RA's de la competencia

            // Establecer la referencia de la competencia en el RA
            ra.setObjCompetencia(competencia); // Establecer la competencia en el RA

            // Guardar los cambios en ambas entidades
            competenciaRepository.save(competencia); // Guardar la competencia actualizada
            resultadoAprendizajeRepository.save(ra); // Guardar el RA actualizado
        }
    }

    @Override
    public void desasociarRa(Integer id, Integer idRa) {
        // Buscar la competencia por su id
        Optional<CompetenciaEntity> optionalCompetencia = competenciaRepository.findById(id);
        // Buscar el resultado de aprendizaje por su id
        Optional<ResultadoAprendizajeEntity> optionalRa = resultadoAprendizajeRepository.findById(idRa);

        // Verificar que ambos objetos existan
        if (optionalCompetencia.isPresent() && optionalRa.isPresent()) {
            CompetenciaEntity competencia = optionalCompetencia.get();
            ResultadoAprendizajeEntity ra = optionalRa.get();

            // Desasociar el resultado de aprendizaje de la competencia
            competencia.getRA().remove(ra); // Eliminar RA de la lista de RA's de la competencia

            // Establecer la referencia de la competencia en el RA
            ra.setObjCompetencia(null); // Establecer la competencia en el RA como null

            // Guardar los cambios en ambas entidades
            competenciaRepository.save(competencia); // Guardar la competencia actualizada
            resultadoAprendizajeRepository.save(ra); // Guardar el RA actualizado
        }
    }

   /*  @Transactional(readOnly = false)
    public void copiarRaDeOtroPeriodo(Integer idAsignaturaOrigen, Integer idPeriodoOrigen, Integer idAsignaturaDestino,
            Integer idPeriodoDestino) {
        // Buscar la asignatura de origen y destino
        Optional<AsignaturaEntity> asignaturaOrigenOpt = asignaturaRepository.findById(idAsignaturaOrigen);
        Optional<AsignaturaEntity> asignaturaDestinoOpt = asignaturaRepository.findById(idAsignaturaDestino);

        if (asignaturaOrigenOpt.isPresent() && asignaturaDestinoOpt.isPresent()) {
            AsignaturaEntity asignaturaOrigen = asignaturaOrigenOpt.get();
            AsignaturaEntity asignaturaDestino = asignaturaDestinoOpt.get();

            // Buscar los RA del periodo origen asociados a la asignatura origen
            List<ResultadoAprendizajeEntity> raOrigenList = resultadoAprendizajeRepository
                    .findByObjAsignaturaAndPeriodo(asignaturaOrigen, idPeriodoOrigen);
            ResultadoAprendizajeEntity raNuevo = new ResultadoAprendizajeEntity();
            // Copiar cada RA y asociarlo al periodo y asignatura de destino
            for (ResultadoAprendizajeEntity raOrigen : raOrigenList) {

                raNuevo.setDescripcionRA(raOrigen.getDescripcionRA());
                raNuevo.setObjCompetencia(raOrigen.getObjCompetencia());

                // Guardar la copia del RA
                resultadoAprendizajeRepository.save(raNuevo);
            }

            Asig_Comp_Doc_Entity asigCompDoc = new Asig_Comp_Doc_Entity();
            asigCompDoc.setOAsignaturaEntity(asignaturaDestino);
            asigCompDoc.setOCompetenciaEntity(raNuevo.getObjCompetencia());

        }
    }*/

}
