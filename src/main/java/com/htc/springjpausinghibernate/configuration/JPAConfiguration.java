package com.htc.springjpausinghibernate.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAspectJAutoProxy
@Configuration
@PropertySource("classpath:database.properties")
@ComponentScan("com.htc.springjpausinghibernate")
@EnableTransactionManagement
public class JPAConfiguration {

	@Autowired
	Environment environement;
	
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environement.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(environement.getProperty("jdbc.url"));
		dataSource.setUsername(environement.getProperty("jdbc.username"));
		dataSource.setPassword(environement.getProperty("jdbc.password"));
		
		return dataSource;
	}
	
	@Bean(name="jpaProperties")
	public Properties getHibernateProperty() {
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.hbm2ddl.auto", "update");
		
		return properties;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getLocalEntityManagerFactoryBean() {
		
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		entityManagerFactory.setDataSource(getDataSource());
		entityManagerFactory.setJpaProperties(getHibernateProperty());
		entityManagerFactory.setPackagesToScan("com.htc.springjpausinghibernate.entity");
		
		return entityManagerFactory;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(
			 EntityManagerFactory entityManagerFactory) {
			 JpaTransactionManager transactionManager = new JpaTransactionManager();
			 transactionManager.setEntityManagerFactory(entityManagerFactory);
			 return transactionManager;
	}
	
	
}
