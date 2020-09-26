package com.github.gilvangobbato.repositories.imp;

import com.github.gilvangobbato.domain.Paciente;
import com.github.gilvangobbato.domain.mapper.PacienteMapper;
import com.github.gilvangobbato.repositories.PacienteRepository;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepositoryImp extends PacienteRepository {

    @Override // SQL UPDATE é utilizando tanto para inserir quanto para atualizar o item
    @SqlUpdate("INSERT INTO pacientes (id, nome, documento, last_update)"
            + "VALUES (:id, :nome, :documento, :lastUpdate)")
    @GetGeneratedKeys // retorna o id do paciente
    Long insert(@BindBean Paciente paciente);

    @Override
    @SqlUpdate("UPDATE pacientes SET nome = :nome, documento = :documento, last_update = :last_update "
            + "WHERE id = :id AND last_update = :lastUpdate ")
    Long update(@BindBean Paciente paciente);

    @Override
    @SqlQuery("SELECT * FROM pacientes WHERE id = :id ")
    Optional<Paciente> findById(Long id);

    @Override
    @SqlQuery
    @UseRowMapper(PacienteMapper.class)
    @UseClasspathSqlLocator // Procura pelo arquivo com mesmo nome do metodo na pasta com.github.gilvangobbato.repositories.imp
    List<Paciente> findAll();
}
