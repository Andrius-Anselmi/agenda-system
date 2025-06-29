package br.com.agendasystem.domain.entity.repository;

import br.com.agendasystem.domain.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
