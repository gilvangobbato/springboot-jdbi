package com.github.gilvangobbato.domain.mapper;

import com.github.gilvangobbato.domain.Paciente;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PacienteMapper implements RowMapper<Paciente> {

    @Override
    public Paciente map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Paciente(rs.getLong("id"),
                rs.getString("nome"),
                rs.getString("documento"),
                rs.getDate("last_update").toInstant());
    }
}
