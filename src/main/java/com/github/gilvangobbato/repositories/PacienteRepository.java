package com.github.gilvangobbato.repositories;

import com.github.gilvangobbato.domain.Paciente;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.locator.UseClasspathSqlLocator;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlBatch;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

@UseClasspathSqlLocator
public interface PacienteRepository {

    @SqlUpdate
    @GetGeneratedKeys
    Long insert(@BindBean Paciente paciente);

    @SqlBatch("insert")
    @GetGeneratedKeys
    List<Long> bulkInsert(@BindBean List<Paciente> pacientes);

    @SqlQuery
    Paciente findById(Long id);

}
