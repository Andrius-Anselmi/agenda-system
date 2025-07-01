package br.com.agendasystem.api.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PacienteRequest {


    String nome;
    String sobrenome;
    String email;
    String cpf;
}
