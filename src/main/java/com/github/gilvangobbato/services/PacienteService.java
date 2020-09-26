package com.github.gilvangobbato.services;

import com.github.gilvangobbato.domain.Paciente;
import com.github.gilvangobbato.exception.NotFoundException;
import com.github.gilvangobbato.repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public Optional<Long> insert(Paciente paciente){
        return Optional.of(pacienteRepository.insert(paciente));
    }

    public Optional<Long> update(Paciente paciente) {
        return Optional.of(pacienteRepository.update(paciente));
    }

    public Paciente findyId(Long id){
        return pacienteRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    public List<Paciente> findAll() {
        return pacienteRepository.findAll();
    }
}
