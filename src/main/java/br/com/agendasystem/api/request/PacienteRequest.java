package br.com.agendasystem.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PacienteRequest {

    @NotBlank(message = "Nome do paciente é obrigatório")
    private String nome;
    @NotBlank(message = "Sobrenome do paciente é obrigatório")
    private String sobrenome;
    private String email;
    @NotBlank(message = "CPF do paciente é obrigatório")
    private String cpf;
}
