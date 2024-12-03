package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.CompetenciaServices;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Competencia.CompetenciaEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.CompetenciaRepository;
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

}
