package com.Config;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import org.apache.tomcat.jdbc.pool.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.apache.tomcat.jdbc.pool.PoolProperties;

@Configuration
@ComponentScan
@EnableJpaRepositories("com")
public class Configurations {
    protected Logger logger;

    public Configurations() {
        logger = Logger.getLogger(getClass().getName());
    }


    @Bean
    public DataSource dataSource() {
        logger.info("dataSource() invoked");
        PoolProperties p = new PoolProperties();
        p.setUrl("jdbc:mysql://localhost:3306/test");
        p.setDriverClassName("com.mysql.jdbc.Driver");
        p.setUsername("root");
        p.setPassword("root");
        DataSource dataSource = new DataSource();
        dataSource.setPoolProperties(p);
        logger.info("dataSource = " + dataSource);
        return dataSource;
    }
}
