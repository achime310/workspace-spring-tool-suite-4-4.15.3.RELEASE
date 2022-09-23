package com.itwill.transaction.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Connection생성클래스
 */
public class ConnectionFactory {
	public static Connection getConnection(){
		String driverClass="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="jdeveloper55";
		String pass="jdeveloper55";
		return getConnection(driverClass, url, user, pass);
	}
	public static Connection getConnection(String driverClass, String url,
			String user, String pass) {
		Connection con = null;
		try {
			Class.forName(driverClass);
			con = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			con = null;
		} catch (SQLException e) {
			e.printStackTrace();
			con = null;
		} finally {
			
		}
		return con;
	}

}
