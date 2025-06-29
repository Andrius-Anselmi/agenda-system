package br.com.agendasystem.domain.entity.service;

import br.com.agendasystem.domain.entity.Paciente;
import br.com.agendasystem.domain.entity.repository.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class PacienteService {

    private final PacienteRepository repository;

    public Paciente criarPaciente(Paciente paciente) {
        return repository.save(paciente);
    }

    public List<Paciente> listarPacientes() {
        return repository.findAll();
    }

    public Optional<Paciente> buscarPacientePorId(Long id) {
        Optional<Paciente> paciente = repository.findById(id);
        if (repository.existsById(id)) {
            return paciente;
        }

        return Optional.empty();
    }
    public void excluirPaciente(Long id) {
        repository.deleteById(id);
    }
}
