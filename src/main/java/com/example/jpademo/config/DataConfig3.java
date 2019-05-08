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
		basePackages = "com.example.jpademo.repository.postgres",
		entityManagerFactoryRef = "postgersEntityManager",
		transactionManagerRef = "postgresTransactionManager"
)public class DataConfig3 {

	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.datasource3")
	public DataSourceProperties datasource3Properties() {
		return new DataSourceProperties();
	}

	@Bean("postgresDataSource")
	@Autowired
	public DataSource datasource3(@Qualifier("datasource3Properties") DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().build();
	}

	@Bean
	@Autowired
	public LocalContainerEntityManagerFactoryBean postgersEntityManager(EntityManagerFactoryBuilder builder,@Qualifier("postgresDataSource") DataSource dataSource){
		return builder.dataSource(dataSource)
				.packages("com.example.jpademo.entity.postgres")
				.persistenceUnit("postgres")
				.build();
	  }

	@Bean
	@Autowired
	public JpaTransactionManager postgresTransactionManager(@Qualifier("postgersEntityManager") LocalContainerEntityManagerFactoryBean secondaryEntityManager) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(secondaryEntityManager.getObject());
		return transactionManager;
	}
}
