package kr.or.ddit.case2.container;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import kr.or.ddit.case2.dao.Case2DAO;
import kr.or.ddit.case2.service.Case2Service;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class DependencyInjectorTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testDependencyInject() {
		Case2DAO dao = DependencyInjector.dependencyInject(Case2DAO.class);
		log.info("주입된 dao : {}", dao);
		Case2Service service = DependencyInjector.dependencyInject(Case2Service.class);
		log.info("주입된 service : {}", service);
		StringBuilder info = service.retrieveCase1Info("c001");
		log.info("조회된 model : {}", info);
	}

}
