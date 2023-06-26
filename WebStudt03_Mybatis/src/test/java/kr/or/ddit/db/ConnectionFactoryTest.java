package kr.or.ddit.db;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class ConnectionFactoryTest {

	@Test
	void testGetConnection() throws SQLException {
		for(int i = 1; i<=1000; i++) {
			try(
					Connection conn = ConnectionFactory.getConnection();
					){
				System.out.println(conn);
			}
		}
	}

}
