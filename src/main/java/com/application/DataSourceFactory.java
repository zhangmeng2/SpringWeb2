package com.application;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages="com.mapper")
public class DataSourceFactory {
	
	@Bean(initMethod="init",destroyMethod="close")
	public static DataSource getDataSource()  
	{  
	String driver = "oracle.jdbc.OracleDriver";  
	String url = "jdbc:oracle:thin:@localhost:1521:ORCL";  
	String username = "zm";  
	String password = "zm123456";  
	PooledDataSource dataSource = new PooledDataSource(driver, url,  
	username, password);  
	return dataSource;  
	}  
	@Bean
	public SqlSessionFactory sessionFactory(ApplicationContext applicationContext) throws Exception{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(getDataSource());
        // 设置 mapper xml
        sessionFactory.setMapperLocations(applicationContext.getResources("classpath:mapper/**/*.xml"));
        return sessionFactory.getObject();
	}
}
