package com.torres.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import org.apache.log4j.Logger;
import java.lang.String;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
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
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(securityDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());
		
		return sessionFactory;
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
	
	// Set up Hibernate properties
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		properties.setProperty("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
		
		return properties;
	}
	
	// Enable Transaction Management
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
	    return new HibernateTransactionManager(sessionFactory);
	}
	
	// Convert String properties to integer values
	private int getIntProperty(String propertyName) {
		String propertyValueString = env.getProperty(propertyName);
		int propertyValueInteger = Integer.parseInt(propertyValueString);
		
		return propertyValueInteger;
	}
}
