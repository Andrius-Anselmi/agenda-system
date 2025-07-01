package br.com.agendasystem.api.mapper;

import br.com.agendasystem.api.request.PacienteRequest;
import br.com.agendasystem.api.response.PacienteResponse;
import br.com.agendasystem.domain.entity.Paciente;


public class PacienteMapper {

    public static Paciente toPaciente(PacienteRequest request) {
        Paciente paciente = new Paciente();
        paciente.setNome(request.getNome());
        paciente.setSobrenome(request.getSobrenome());
        paciente.setEmail(request.getEmail());
        paciente.setCpf(request.getCpf());
        return paciente;
    }

    public static PacienteResponse toPacienteResponse(Paciente paciente) {
        PacienteResponse pacienteResponse = new PacienteResponse();
        pacienteResponse.setId(paciente.getId());
        pacienteResponse.setNome(paciente.getNome());
        pacienteResponse.setSobrenome(paciente.getSobrenome());
        pacienteResponse.setEmail(paciente.getEmail());
        pacienteResponse.setCpf(paciente.getCpf());
        return pacienteResponse;

    }




}


