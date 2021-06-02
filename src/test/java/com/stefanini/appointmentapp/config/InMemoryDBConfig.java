package com.stefanini.appointmentapp.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
public class InMemoryDBConfig {
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.pass"));

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean factoryBean() {
        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        Properties properties = new Properties();
        properties.setProperty("javax.persistence.schema-generation.database.action", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        factory.setJpaProperties(properties);
        return factory;
    }
}
