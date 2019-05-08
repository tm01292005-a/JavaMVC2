package com.example.jpademo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * SqlSessionFactoryBean格納クラス
 */
@Configuration
@EnableJpaRepositories(
		basePackages = "com.example.jpademo.repository.oracle1",
		entityManagerFactoryRef = "oracle1EntityManager",
		transactionManagerRef = "oracle1TransactionManager"
)
public class DataConfig1 {
	@Bean
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.datasource1")
	public DataSourceProperties datasource1Properties() {
		return new DataSourceProperties();
	}

	@Bean("oracle1DataSource")
	@Primary
	@Autowired
	public DataSource datasource1(@Qualifier("datasource1Properties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}

	@Bean
	@Primary
	@Autowired
	public LocalContainerEntityManagerFactoryBean oracle1EntityManager(EntityManagerFactoryBuilder builder,@Qualifier("oracle1DataSource") DataSource dataSource) {
		return builder.dataSource(dataSource)
				.packages("com.example.jpademo.entity.oracle1")
				.persistenceUnit("oracle1")
				.build();
	}

	@Bean
	@Primary
	@Autowired
	public JpaTransactionManager oracle1TransactionManager(@Qualifier("oracle1EntityManager") LocalContainerEntityManagerFactoryBean primaryEntityManager) {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(primaryEntityManager.getObject());
	    return transactionManager;
	  }
}
