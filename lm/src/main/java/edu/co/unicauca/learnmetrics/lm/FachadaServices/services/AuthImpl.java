package edu.co.unicauca.learnmetrics.lm.FachadaServices.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.response.JwtResponseDTO;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.request.LoginRequestDTO;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.response.MessageResponseDTO;
import edu.co.unicauca.learnmetrics.lm.FachadaServices.DTO.request.SignupRequestDTO;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.ERole;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.Role;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.DocenteEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.RoleRepository;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.DocenteRepository;
import edu.co.unicauca.learnmetrics.lm.security.jwt.JwtUtils;
import edu.co.unicauca.learnmetrics.lm.security.services.UserDetailsImpl;






@Service
public class AuthImpl implements AuthInt{

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    DocenteRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;


    @Override
    public JwtResponseDTO authenticateUser(LoginRequestDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
        List<String> roles = userDetails.getAuthorities().stream()
            .map(item -> item.getAuthority())
            .collect(Collectors.toList());

        return new JwtResponseDTO(jwt, 
        userDetails.getId(), 
        userDetails.getUsername(), 
        userDetails.getEmail(), 
        roles,
        userDetails.getNombre(),
        userDetails.getApellido(),
        userDetails.getIdentificacion(),
        userDetails.getTipoDeIdentificacion().name(),
        userDetails.getTitulo(),
        userDetails.getTipoDeDocente().name());
    }

    @Override
    public MessageResponseDTO registerUser(SignupRequestDTO signUpRequest) {
       
        DocenteEntity user = new DocenteEntity(signUpRequest.getUsername(),
                            signUpRequest.getEmail(),
                            encoder.encode(signUpRequest.getPassword()),
                            signUpRequest.getNombre(),
                            signUpRequest.getApellido(),
                            signUpRequest.getIdentificacion(),
                            signUpRequest.getTipoDeIdentificacion(),
                            signUpRequest.getTitulo(),
                            signUpRequest.getTipoDeDocente());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_DOCENTE)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "coordinador":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_COORDINADOR)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                    break;
                    case "docente":
                        Role modRole = roleRepository.findByName(ERole.ROLE_DOCENTE)
                            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);
        return new MessageResponseDTO("Usuario "+user.getUsername()+" creado exitosamente");
    }

}
