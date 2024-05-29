package org.devnot.multidatabase.infra.datasource.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.init.DataSourceScriptDatabaseInitializer;
import org.springframework.boot.sql.init.DatabaseInitializationMode;
import org.springframework.boot.sql.init.DatabaseInitializationSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.simple.JdbcClient;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class DataSourceConfiguration {

    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.users")
    @Bean
    DataSourceProperties usersDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    DataSource usersDataSource(DataSourceProperties userDsProps){
        return userDsProps.initializeDataSourceBuilder().build();
    }

    @Primary
    @Bean
    JdbcClient usersJdbcClient(DataSource dataSource){
        return JdbcClient.create(dataSource);
    }

    @Bean
    DataSourceScriptDatabaseInitializer usersDataSourceScriptDatabaseInitializer(DataSource dataSource){
        var settings = new DatabaseInitializationSettings();
        settings.setSchemaLocations(List.of("classpath:/db/users/users-schema.sql"));
        settings.setMode(DatabaseInitializationMode.ALWAYS);
        return new DataSourceScriptDatabaseInitializer(dataSource, settings);
    }

    @ConfigurationProperties(prefix = "spring.datasource.main")
    @Bean
    DataSourceProperties mainDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    DataSource mainDataSource(
            @Qualifier("mainDataSourceProperties") DataSourceProperties mainDsProps){
        return mainDsProps.initializeDataSourceBuilder().build();
    }

    @Bean
    JdbcClient mainJdbcClient(
            @Qualifier("mainDataSource") DataSource mainDataSource){
        return JdbcClient.create(mainDataSource);
    }

    @Bean
    DataSourceScriptDatabaseInitializer mainDataSourceScriptDatabaseInitializer(
            @Qualifier("mainDataSource")DataSource mainDataSource){
        var settings = new DatabaseInitializationSettings();
        settings.setSchemaLocations(List.of("classpath:/db/main/main-schema.sql"));
        settings.setMode(DatabaseInitializationMode.ALWAYS);
        return new DataSourceScriptDatabaseInitializer(mainDataSource, settings);
    }
}
