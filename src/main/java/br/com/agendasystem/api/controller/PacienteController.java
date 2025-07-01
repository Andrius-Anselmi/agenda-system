package br.com.agendasystem.api.controller;

import br.com.agendasystem.api.mapper.PacienteMapper;
import br.com.agendasystem.api.request.PacienteRequest;
import br.com.agendasystem.api.response.PacienteResponse;
import br.com.agendasystem.config.ModalMapperConfig;
import br.com.agendasystem.domain.entity.Paciente;
import br.com.agendasystem.domain.entity.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService service;
    private final PacienteMapper mapper;

    @PostMapping()
    public ResponseEntity<PacienteResponse> salvar(@RequestBody PacienteRequest request) {
        Paciente pacienteSalvo = service.salvar(mapper.toPaciente(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toPacienteResponse(pacienteSalvo));
    }

    @GetMapping()
    public ResponseEntity<List<PacienteResponse>> listarTodos() {
        List<Paciente> pacientes = service.listarTodos();
        return ResponseEntity.ok(mapper.toPacienteResponseList(pacientes));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponse> buscarPorId(@PathVariable Long id) {
        Optional<Paciente> paciente = service.buscarPorId(id);
        if(paciente.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(mapper.toPacienteResponse(paciente.get()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PacienteResponse> atualizar(@PathVariable Long id, @RequestBody PacienteRequest request) {
        Optional<Paciente> pacienteBuscado = service.buscarPorId(id);
        if(pacienteBuscado.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Paciente paciente = pacienteBuscado.get();
        paciente.setNome(request.getNome());
        paciente.setEmail(request.getEmail());
        paciente.setCpf(request.getCpf());
        paciente.setSobrenome(request.getSobrenome());

        Paciente pacienteAtualizado = service.salvar(paciente);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toPacienteResponse(pacienteAtualizado));

    }
}
