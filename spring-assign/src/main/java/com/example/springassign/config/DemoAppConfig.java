package com.example.springassign.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Component
@EnableWebMvc
@ComponentScan(basePackages="com.example")//to read base package spring security demo
@PropertySource("classpath:application.properties")//to read mysql.properties from resources
public class DemoAppConfig {

    //set up variable to hold up properties
    @Autowired
    private Environment env;//holds data read from properties file

    //setup logger for diagnostics
    private Logger logger= Logger.getLogger(getClass().getName());


    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver= new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");


        return viewResolver;
    }

    //define a bean for security datasource
    @Bean
    public DataSource securityDataSource() {
        //create connection pool
        ComboPooledDataSource securityDataSource= new ComboPooledDataSource();

        //set the jdbc driver class

        try {
            securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));//from props file
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        //log the connection props
        logger.info(">>> jdbc.url=" +env.getProperty("jdbc.url"));
        logger.info(">>> jdbc.user=" +env.getProperty("jdbc.user"));

        //set database connection props
        securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUser(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));

        //set connection pool props
        securityDataSource.setInitialPoolSize(
                getIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(
                getIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(
                getIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(
                getIntProperty("connection.pool.maxIdleTime"));
        return securityDataSource;
    }

    private int getIntProperty(String propName){
        String propVal= env.getProperty(propName);
        int intPropVal= Integer.parseInt(propVal);
        return intPropVal;
    }
}
