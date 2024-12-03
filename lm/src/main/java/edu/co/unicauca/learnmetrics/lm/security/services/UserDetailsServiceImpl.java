package edu.co.unicauca.learnmetrics.lm.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.DocenteEntity;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios.DocenteRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  DocenteRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    DocenteEntity user = userRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

    return UserDetailsImpl.build(user);
  }

}
