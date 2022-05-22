package com.groupware.presistence;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracieDriver");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void testConnection() {
		try (
			Connection conn =
			DriverManager.getConnection("jdbc:log4jdbc:oracle:thin:@3.37.246.102:1521:XE", "hecto", "hecto"))
			{log.info(conn);}
		catch (Exception e) {}
	}
}
