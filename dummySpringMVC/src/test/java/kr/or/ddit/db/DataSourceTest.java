package kr.or.ddit.db;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/resources/kr/or/ddit/spring/conf/*-context.xml")
@WebAppConfiguration
class DataSourceTest {

	@Inject
	private DataSource dataSource;
	
	
	@Test
	void test() throws SQLException {
		log.info("주입 객체 : {} " , dataSource);
		log.info(" connection : {}" , dataSource.getConnection());
	}

}
