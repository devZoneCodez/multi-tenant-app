package io.devzonecodez.mt.config.ds;

import io.devzonecodez.mt.config.web.TenantContextHolder;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;


@Configuration
public class DataSourceConfig {

    @Autowired
    private DataSourceProps dataSourceProps;

    @Bean
    public DataSource dataSource() {
        TenantDataSource customDataSource = new TenantDataSource();
        customDataSource.setTargetDataSources(dataSourceProps.getDataSources());
        /*
            TODO: the default datasource to be set - Hence, set one of the teanant
             as default tenant
         */
        TenantContextHolder.setTenantId("tenantone");
        customDataSource.afterPropertiesSet();

        return customDataSource;
    }

    @PostConstruct
    public void migrate() {
        dataSourceProps
                .getDataSources()
                .values()
                .stream()
                .map(DataSource.class::cast)
                .forEach(this::migrate);
    }

    private void migrate(DataSource dataSource) {
        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.migrate();
    }
}
