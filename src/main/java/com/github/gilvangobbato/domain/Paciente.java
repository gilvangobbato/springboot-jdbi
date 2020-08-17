package com.github.gilvangobbato.domain;

import lombok.Data;

@Data
public class Paciente {
    private Long id;
    private String nome;
    private String documento;
}
