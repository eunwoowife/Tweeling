package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// DB와 접속된 Connection 객체를 생성해서 반환시켜주는 메소드
public class JDBCTemplate {
	// 1. Connection 객체 생성(DB 접속)한 후 해당 Connection 객체를 반환
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		
		// 읽을 driver.properties 파일의 물리적인 경로
		// FileInputStream("드라이버.properties파일경로");
		// 실질적으로 배포되는 폴더는 WebContent라서 src/db/driver/driver.properties를 읽어도 의미가 없다.
		// 실질적으로 배포되는 폴더 안에 있는 classes폴더에 있는 것을 읽어줘야 한다.
		String filePath = JDBCTemplate.class.getResource("/db/driver/driver.properties").getPath();
		// 물리적인 경로 얻기 JDBCTemplate.class : 실질적인 클래스파일 경로
//		System.out.println(filePath);
		
		try {
			prop.load(new FileInputStream(filePath));
			Class.forName(prop.getProperty("driver"));
			
			conn = DriverManager.getConnection(prop.getProperty("url")
											, prop.getProperty("username")
											, prop.getProperty("password"));
//			System.out.println("conn : "+ conn);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 2. 전달받은 JDBC용 객체를 반납시켜주는 메서드 (각 객체별로 생성)
	// 2_1) connection 객체 반납 메서드
	public static void close(Connection conn) {
		try {
			//만약 conn이 null이면 nullPointerException이 발생할 수 있어서 조건처리 해야 함
			if(conn != null && conn.isClosed()) {	// conn이 null도 아니고 열려있으면
				conn.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 2_2) Statement 객체 반납 메서드(오버로딩)
	// PreparedStatement는 따로 만들지 않는 이유 : Statement가 부모라서 다형성이 적용됨
	public static void close(Statement stmt) {
		try {
			//만약 stmt이 null이면 nullPointerException이 발생할 수 있어서 조건처리 해야 함
			if(stmt != null && stmt.isClosed()) {	// stmt이 null도 아니고 열려있으면
				stmt.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 2_3) ResultSet 객체 반납 메서드(오버로딩)
	public static void close(ResultSet rset) {
		try {
			//만약 stmt이 null이면 nullPointerException이 발생할 수 있어서 조건처리 해야 함
			if(rset != null && rset.isClosed()) {	// rset이 null도 아니고 열려있으면
				rset.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 3) 트랜잭션 처리 메서드
	// 3_1) commit 메서드
	public static void commit(Connection conn) {
		try {
			if(conn != null && conn.isClosed()) {
				conn.commit();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 3_2) rollback 메서드
	public static void rollback(Connection conn) {
		try {
			if(conn != null && conn.isClosed()) {
				conn.rollback();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
