package edu.co.unicauca.learnmetrics.lm.FachadaServices.services.Asig_Comp_Doc_Service;

import java.util.List;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.Asig_Comp_Doc_DTO;

public interface IAsig_Comp_Doc {

    public Asig_Comp_Doc_DTO save(Asig_Comp_Doc_DTO asi_comp_doc);

    public boolean delete(Integer asi_comp_doc_ID);

    public List<Asig_Comp_Doc_DTO> findAll();

    public Asig_Comp_Doc_DTO findByID(Integer asi_comp_doc_ID);

    public Asig_Comp_Doc_DTO update(Integer id, Asig_Comp_Doc_DTO asi_comp_doc);

}
