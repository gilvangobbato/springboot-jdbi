package com.github.gilvangobbato.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class Paciente {
    private Long id;
    private String nome;
    private String documento;

    @ConstructorProperties({"id", "nome", "documento"})
    public Paciente(Long id, String nome, String documento) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
    }
}
