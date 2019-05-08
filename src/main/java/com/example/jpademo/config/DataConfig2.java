package com.example.jpademo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * SqlSessionFactoryBean格納クラス
 */
@Configuration
@EnableJpaRepositories(
		basePackages = "com.example.jpademo.repository.oracle2",
		entityManagerFactoryRef = "oracle2EntityManager",
		transactionManagerRef = "oracle2TransactionManager"
)
public class DataConfig2 {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.datasource2")
	public DataSourceProperties datasource2Properties() {
		return new DataSourceProperties();
	}

	@Bean("oracle2DataSource")
	@Autowired
	public DataSource datasource2(@Qualifier("datasource2Properties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}

	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean oracle2EntityManager(EntityManagerFactoryBuilder builder,@Qualifier("oracle2DataSource") DataSource dataSource){
		return builder.dataSource(dataSource)
				.packages("com.example.jpademo.entity.oracle2")
				.persistenceUnit("oracle2")
				.build();
	  }

	@Bean
	@Autowired
	public JpaTransactionManager oracle2TransactionManager(@Qualifier("oracle2EntityManager") LocalContainerEntityManagerFactoryBean secondaryEntityManager) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(secondaryEntityManager.getObject());
		return transactionManager;
	}
}
