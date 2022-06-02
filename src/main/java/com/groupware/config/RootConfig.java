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
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
<<<<<<< HEAD
@ComponentScan(basePackages = {"com.groupware.controller", "com.groupware.service","com.groupware.*"})
@MapperScan(basePackages = {"com.groupware.mapper","com.groupware.dto","com.groupware.vo"})
public class RootConfig {
=======
@ComponentScan(basePackages = {"com.groupware.controller", "com.groupware.service"})
@MapperScan(basePackages = {"com.groupware.mapper","com.groupware.dto"})
public class RootConfig implements WebMvcConfigurer {
>>>>>>> 457e3ca7769cbac2906710120786be81e281095b
	
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
		sqlSessionFactory.setTypeAliasesPackage("com.groupware.*");
		return (SqlSessionFactory)sqlSessionFactory.getObject();
	}


}