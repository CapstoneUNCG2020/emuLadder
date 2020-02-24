package com.uncg.emuLadder.config.database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Formatter;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    @Value("${database.driver.driver}")
    private String driver;

    @Value("${database.description.url}")
    private String url;

    @Value("${database.description.databaseName}")
    private String databaseName;

    @Value("${database.description.port}")
    private int port;

    @Value("${database.driver.driverClassName}")
    private String driverClassName;

    @Value("${database.credentials.username}")
    private String username;

    @Value("${database.credentials.password}")
    private String password;

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(
                new Formatter().format("%s://%s:%d/%s", driver, url, port, databaseName).toString()
        );
        dataSourceBuilder.driverClassName(driverClassName);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }
}
