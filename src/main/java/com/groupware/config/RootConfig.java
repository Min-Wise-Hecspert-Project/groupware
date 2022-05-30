package com.groupware.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"com.groupware.controller", "com.groupware.service","com.groupware.util"})
@MapperScan(basePackages = {"com.groupware.mapper","com.groupware.dto"})
public class RootConfig {
	
	@Bean // �޼ҵ��� ���� ����� ��ȯ�Ǵ� ��ü�� ������ ��ü�� ���
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
//		jdbc:log4jdbc:oracle:thin:@3.37.246.102:1521:XE
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@3.37.246.102:1521:XE");
		hikariConfig.setUsername("hecto");
		hikariConfig.setPassword("hecto");
		
		return new HikariDataSource(hikariConfig);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		sqlSessionFactory.setTypeAliasesPackage("com.groupware.dto");
		return (SqlSessionFactory)sqlSessionFactory.getObject();
	}
}