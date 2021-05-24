package com.stefanini.appointmentapp.config;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import javax.sql.DataSource;
import java.util.*;

@Configuration
public class EntityManagerFactory {

    private final Environment environment;

    public EntityManagerFactory(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource getMySQLDataSource() {

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setPassword(environment.getProperty("spring.datasource.password"));
        dataSource.setUser(environment.getProperty("spring.datasource.username"));
        dataSource.setUrl(environment.getProperty("spring.datasource.url"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean factoryBean() {
        LocalContainerEntityManagerFactoryBean factory =
                new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(getMySQLDataSource());
        factory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        Properties properties = new Properties();
        properties.setProperty("javax.persistence.schema-generation.database.action", environment.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.setProperty("hibernate.show_sql", environment.getProperty("spring.jpa.show-sql"));
        factory.setJpaProperties(properties);
        return factory;
    }

}
