package com.github.gilvangobbato.repositories;

import com.github.gilvangobbato.domain.Paciente;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlBatch;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository {

    @SqlUpdate("INSERT INTO pacientes (id, nome, documento, last_update)"
            + "VALUES (:id, :nome, :documento, :lastUpdate)")
    @GetGeneratedKeys
    Long insert(@BindBean Paciente paciente);

    @SqlUpdate("UPDATE pacientes SET nome = :nome, documento = :documento "
            + "WHERE id = :id AND last_update = :lastUpdate ")
    Long update(@BindBean Paciente paciente);

    @SqlBatch("insert")
    @GetGeneratedKeys
    List<Long> bulkInsert(@BindBean List<Paciente> pacientes);

    @SqlQuery
    @UseClasspathSqlLocator
    Paciente findById(Long id);
}
