package br.com.agendasystem.api.mapper;

import br.com.agendasystem.api.request.PacienteRequest;
import br.com.agendasystem.api.response.PacienteResponse;
import br.com.agendasystem.domain.entity.Paciente;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PacienteMapper {

    private final ModelMapper modelMapper;

    public Paciente toPaciente(PacienteRequest request) {
        return modelMapper.map(request,Paciente.class);
    }

    public PacienteResponse toPacienteResponse(Paciente paciente) {
        return modelMapper.map(paciente, PacienteResponse.class);
    }
    public List<PacienteResponse> toPacienteResponseList(List<Paciente> pacientes) {
       return pacientes.stream()
               .map(paciente -> modelMapper.map(paciente,PacienteResponse.class)).toList();
    }

}


