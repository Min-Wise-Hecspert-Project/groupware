package com.groupware.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = {"com.groupware.controller", "com.groupware.service"})
@MapperScan(basePackages = {"com.groupware.mapper"})
public class RootConfig {
	
	@Bean // 메소드의 실행 결과로 반환되는 객체는 스프링 객체로 등록
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:XE");
		hikariConfig.setUsername("scott");
		hikariConfig.setPassword("tiger");
		
		return new HikariDataSource(hikariConfig);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
//		typeAlias 설정하기
//		sqlSessionFactory.setTypeAliasesPackage("com.groupware.vo");
		return (SqlSessionFactory)sqlSessionFactory.getObject();
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException{
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(1024*1024*10);
		resolver.setMaxUploadSizePerFile(1024*1024*10);
		resolver.setMaxInMemorySize(1024*1024);
		//디스크에 저장하지 않고 메모리에 유지하도록 허용하는 바이트 단위의 최대 용량을 설정
		resolver.setUploadTempDir(new FileSystemResource("e:/upload"));
		resolver.setDefaultEncoding("utf-8");
		
		return resolver;
	}
}