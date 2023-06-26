package kr.or.ddit.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Factory Object Pattern : 의존 객체의 생성을 전담하는 factory object 운영.
 *
 */
public class ConnectionFactory {
	private static String url;
	private static String user;
	private static String password;
	private static DataSource dataSource;
	static {
		ResourceBundle bundle = ResourceBundle.getBundle("kr/or/ddit/db/dbInfo");
		url = bundle.getString("url");
		user = bundle.getString("user");
		password = bundle.getString("password");
//		try {
		dataSource = new BasicDataSource();
		BasicDataSource ds = (BasicDataSource) dataSource;
		ds.setDriverClassName(bundle.getString("driverClassName"));
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);
		ds.setInitialSize(Integer.parseInt(bundle.getString("initialSize"))); // 5개의 커넥션을 만들어놓음.
		ds.setMaxTotal(Integer.parseInt(bundle.getString("maxTotal"))); // 5개를 다차면 다시 10개까지 만듬(여유분)
		ds.setMaxWaitMillis(Long.parseLong(bundle.getString("maxWait"))); // 늘리다가 최대한도까지 오면, 2000-> 2초를 대기시킴, 안되면 SQL
																			// exception을 작동키심.
//		}catch (SQLException e) {
//			throw new PersistenceException(e);
//		}
//		try {
//			Class.forName(bundle.getString("driverClassName"));
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException(e);
//		}
	}

	public static Connection getConnection() throws SQLException {
//		Connection conn= DriverManager.getConnection(url, user, password);
		Connection conn = dataSource.getConnection();
		conn.setAutoCommit(false);
		return conn;
	}
}
