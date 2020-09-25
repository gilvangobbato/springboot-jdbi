package com.github.gilvangobbato.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.beans.ConstructorProperties;
import java.time.Instant;

@Data
public class Paciente {
    private Long id;
    private String nome;
    private String documento;
    private Instant lastUpdate;

    @ConstructorProperties({"id", "nome", "documento", "last_update"})
    public Paciente(Long id, String nome, String documento, Instant lastUpdate) {
        this.id = id;
        this.nome = nome;
        this.documento = documento;
        this.lastUpdate = lastUpdate;
    }
}
