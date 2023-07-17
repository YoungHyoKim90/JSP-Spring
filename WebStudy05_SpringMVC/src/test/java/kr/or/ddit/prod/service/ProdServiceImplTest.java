package kr.or.ddit.prod.service;

import static org.junit.jupiter.api.Assertions.fail;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ProdServiceImplTest extends AbstractRootTest{
	
	@Inject
	private ProdService service;

	@Test
	void testRetrieveProd() {
		log.info("주입 객체 : {}", service);
		log.info("조회 데이터 : {}", service.retrieveProd("P101000001"));
	}

}

















