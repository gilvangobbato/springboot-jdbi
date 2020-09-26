package com.github.gilvangobbato.config;

import com.github.gilvangobbato.repositories.PacienteRepository;
import com.github.gilvangobbato.repositories.imp.PacienteRepositoryImp;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class JdbiConfiguration {

    @Bean
    public Jdbi jdbi(DataSource ds, List<JdbiPlugin> jdbiPlugins, List<RowMapper<?>> rowMappers) {
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(ds);
        Jdbi jdbiLoc = Jdbi.create(proxy);

        jdbiPlugins.forEach(plugin -> jdbiLoc.installPlugin(plugin));
        rowMappers.forEach(mapper -> jdbiLoc.registerRowMapper(mapper));

        return jdbiLoc;
    }

    /**
     * Para cada repository deve ser fornecido um bean
     */
    @Bean
    public PacienteRepositoryImp pacienteRepository(Jdbi jdbi) {
        return jdbi.onDemand(PacienteRepositoryImp.class);
    }

    @Bean
    public JdbiPlugin sqlObjectPlugin() {
        return new SqlObjectPlugin();
    }
}
