package br.com.agendasystem.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PacienteResponse {

    Long id;
    String nome;
    String sobrenome;
    String email;
    String cpf;
}
