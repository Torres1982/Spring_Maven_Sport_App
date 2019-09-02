package com.torres.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {	
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
		builder.scanPackages("com.torres.model").addProperties(hibernateProperties());
		return builder.buildSessionFactory();
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/football");
	    dataSource.setUsername("Artur");
		dataSource.setPassword("admin");
	
		return dataSource;
	}
	
	private Properties hibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    properties.put("hibernate.show_sql", true);
	    properties.put("hibernate.format_sql", true);
	    properties.put("hibernate.jdbc.batch_size", 16);
	    properties.put("hibernate.c3p0.min_size", 5);
	    properties.put("hibernate.c3p0.max_size", 20);
	    properties.put("hibernate.c3p0.timeout", 1800);
	    properties.put("hibernate.c3p0.max_statements", 50);
	    
	    return properties;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
	    return new HibernateTransactionManager(sessionFactory());
	}
}
