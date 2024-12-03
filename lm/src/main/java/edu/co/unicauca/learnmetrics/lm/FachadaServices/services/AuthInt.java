package edu.co.unicauca.learnmetrics.lm.FachadaServices.services;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.response.JwtResponseDTO;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.request.LoginRequestDTO;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.response.MessageResponseDTO;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.request.SignupRequestDTO;



public interface AuthInt {
   JwtResponseDTO authenticateUser( LoginRequestDTO loginRequest);
   MessageResponseDTO registerUser(SignupRequestDTO signUpRequest);
}
