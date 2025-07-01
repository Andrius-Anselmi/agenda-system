package br.com.agendasystem.api.controller;

import br.com.agendasystem.api.mapper.PacienteMapper;
import br.com.agendasystem.api.request.PacienteRequest;
import br.com.agendasystem.api.response.PacienteResponse;
import br.com.agendasystem.domain.entity.Paciente;
import br.com.agendasystem.domain.entity.service.PacienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService service;

    @PostMapping()
    public ResponseEntity<PacienteResponse> salvar(@RequestBody PacienteRequest request) {
        Paciente pacienteSalvo = service.salvar(PacienteMapper.toPaciente(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(PacienteMapper.toPacienteResponse(pacienteSalvo));
    }

    @GetMapping()
    public ResponseEntity<List<PacienteResponse>> listarTodos() {
        List<Paciente> pacientes = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(pacientes.stream().map(PacienteMapper::toPacienteResponse).toList());
    }
}
