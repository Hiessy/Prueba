package com.web.application.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

@Configuration
public class DataSourceConfig {

    @Bean
    public static DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
            .generateUniqueName(true)
            .setType(org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType.H2)
            .setScriptEncoding("UTF-8")
            .ignoreFailedDrops(true)
            .addScript("/datasource/create_schema.sql")
            .addScript("/datasource/insert_data.sql")
            .build();
    }
}