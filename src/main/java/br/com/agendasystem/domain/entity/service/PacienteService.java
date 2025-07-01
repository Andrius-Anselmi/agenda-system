package br.com.agendasystem.domain.entity.service;

import br.com.agendasystem.domain.entity.Paciente;
import br.com.agendasystem.domain.entity.repository.PacienteRepository;
import br.com.agendasystem.exception.BusinessException;
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

    public Paciente salvar(Paciente paciente) {
        return repository.save(paciente);
    }

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public Optional<Paciente> buscarPorId(Long id) {
        Optional<Paciente> paciente = repository.findById(id);
        if (repository.existsById(id)) {
            return paciente;
        }

        return Optional.empty();
    }
    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
