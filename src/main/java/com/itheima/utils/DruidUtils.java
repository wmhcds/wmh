package com.itheima.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * dsjakhd
 * dsakdja
 * @author wmh
 *
 */
public class DruidUtils {
	
	//public static final String className = "jdbc:oracle:thin:@localhost:1521/orcl";
	//public static final String url = "oracle.jdbc.driver.OracleDriver";
	public static final String className = "com.mysql.jdbc.Driver";
	public static final String url = "jdbc:mysql:///test";
	public static final String username = "root";
	public static final String password = "1234";

	public static Logger logger = Logger.getLogger("log");
	public static Connection conn = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet result = null;

	public static Connection getConnection() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(className);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		try {
			conn = dataSource.getConnection();
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			logger.info("数据库连接失败");
			return null;
		}
	}

	public static ResultSet query(String sql) {
		if (conn == null) {
			getConnection();
		}
		try {
			pstmt = conn.prepareStatement(sql);
			return pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void close() {
		try {
			if (conn != null)
				conn.close();
			if (pstmt != null)
				pstmt.close();
			if (result != null)
				result.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void main(String[] args) throws SQLException {
		ResultSet query = query("select * from user");
		while (query.next()) {
			String string = query.getString(1);
			System.out.println(string);
		}
	}

}
