package com.torres.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import org.apache.log4j.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:jdbc.properties")
public class HibernateConfig {
	@Autowired
	private Environment env;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(securityDataSource());
		builder.scanPackages("com.torres.model").addProperties(hibernateProperties());
		//builder.scanPackages("com.torres.model");
		return builder.buildSessionFactory();
	}
	
	@Bean
	public DataSource securityDataSource() {
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		logger.info("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& JDBC url: " + env.getProperty("jdbc.url"));
		logger.info("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& JDBC user: " + env.getProperty("jdbc.user"));
		logger.info("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& JDBC pass: " + env.getProperty("jdbc.password"));
		logger.info("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Initial Pool Size: " + env.getProperty("connection.pool.initialPoolSize"));
		logger.info("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Min Pool Size: " + env.getProperty("connection.pool.minPoolSize"));
		logger.info("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& Max Pool Size: " + env.getProperty("connection.pool.maxPoolSize"));
		
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	private int getIntProperty(String propertyName) {
		String propertyValueString = env.getProperty(propertyName);
		int propertyValueInteger = Integer.parseInt(propertyValueString);
		
		return propertyValueInteger;
	}
	
//	@Bean
//	public DataSource dataSource() {
//		//DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		ComboPooledDataSource dataSource = new ComboPooledDataSource();
//		try {
//			dataSource.setDriverClass("com.mysql.jdbc.Driver");
//		} catch (PropertyVetoException e) {
//			throw new RuntimeException(e);
//		}
//		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/football");
//	    dataSource.setUser("Artur");
//		dataSource.setPassword("admin");
//	
//		return dataSource;
//	}
	
	private Properties hibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    properties.put("hibernate.show_sql", true);
	    properties.put("hibernate.format_sql", true);
//	    properties.put("hibernate.jdbc.batch_size", 16);
//	    properties.put("hibernate.c3p0.min_size", 5);
//	    properties.put("hibernate.c3p0.max_size", 20);
//	    properties.put("hibernate.c3p0.timeout", 3000);
//	    properties.put("hibernate.c3p0.max_statements", 50);
//	    
	    return properties;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager() {
	    return new HibernateTransactionManager(sessionFactory());
	}
}
