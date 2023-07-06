package kr.or.ddit.jdbc_mybatis;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.TransactionManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(locations = "file:src/main/resources/kr/or/ddit/jdbc_mybatis/dataSource-context.xml")
class DataSourceTest {
	
	@Inject
	@Named("dataSource")
	private DataSource dataSource;
	
	@Autowired
	private TransactionManager txManager;
	
	@Test
	void test() throws SQLException {
		log.info("주입된 객체 : {}", dataSource);
		log.info("connectino : {}", dataSource.getConnection());
		log.info("txManager : {}", txManager);
	}

}

















