package com.github.gilvangobbato.controller;

import com.github.gilvangobbato.domain.Paciente;
import com.github.gilvangobbato.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public Long insert(Paciente paciente) throws RuntimeException {
        return this.pacienteService.insert(paciente)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao inserir paciente.")
                );
    }

    @PutMapping
    public ResponseEntity<Long> update(Paciente paciente) throws RuntimeException {
        Long retorno = this.pacienteService.update(paciente)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Erro ao inserir paciente.")
                );
        return ResponseEntity.ok(retorno);
    }
}
