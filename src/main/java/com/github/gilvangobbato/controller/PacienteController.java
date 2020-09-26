package com.github.gilvangobbato.controller;

import com.github.gilvangobbato.domain.Paciente;
import com.github.gilvangobbato.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    @GetMapping(path = "/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable("id") Long id){
        Paciente bean = pacienteService.findyId(id);
        return ResponseEntity.ok(bean);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> findAll(){
        List<Paciente> lista = pacienteService.findAll();
        return ResponseEntity.ok(lista);
    }
}
