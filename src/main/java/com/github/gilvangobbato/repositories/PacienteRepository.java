package com.github.gilvangobbato.repositories;

import com.github.gilvangobbato.domain.Paciente;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository {

    Long insert(@BindBean Paciente paciente);

    Long update(@BindBean Paciente paciente);

    Optional<Paciente> findById(Long id);

    List<Paciente> findAll();
}
