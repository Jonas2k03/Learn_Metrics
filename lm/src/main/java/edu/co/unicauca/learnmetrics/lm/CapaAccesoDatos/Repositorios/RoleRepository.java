package edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Repositorios;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.ERole;
import edu.co.unicauca.learnmetrics.lm.CapaAccesoDatos.Modelos.Docente.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(ERole name);
}
