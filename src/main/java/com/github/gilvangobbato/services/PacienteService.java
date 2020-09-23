package com.github.gilvangobbato.services;

import com.github.gilvangobbato.domain.Paciente;
import com.github.gilvangobbato.repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public Long insert(Paciente paciente){
        return pacienteRepository.insert(paciente);
    }
}
