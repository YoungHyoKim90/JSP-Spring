package kr.or.ddit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *  Factory Object Pattern
 *  	: 의존 객체의 생성을 전담하는 factory object 운영.
 *
 */
public class ConnectionFactory {
	private static String url;
	private static String user;
	private static String password;
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("kr/or/ddit/db/dbInfo");
		url = bundle.getString("url");
		user = bundle.getString("user");
		password = bundle.getString("password");
		try {
			Class.forName(bundle.getString("driverClassName"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
}




















