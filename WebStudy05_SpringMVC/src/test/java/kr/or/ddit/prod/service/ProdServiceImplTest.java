package kr.or.ddit.prod.service;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import kr.or.ddit.AbstractRootTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ProdServiceImplTest extends AbstractRootTest {

	@Inject
	private ProdService service;
	
	
	@Test
	void testRetrieveProd() {

		log.info("주입된 객체 : {}" , service);
		log.info("조회 데이터 : {} " , service.retrieveProd("P101000001"));
	}

}
