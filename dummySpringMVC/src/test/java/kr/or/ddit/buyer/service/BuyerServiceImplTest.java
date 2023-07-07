package kr.or.ddit.buyer.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitWebConfig(locations ="file:src/main/resources/kr/or/ddit/spring/conf/*-context.xml")
class BuyerServiceImplTest {

	@Inject
	private BuyerService service;
	
	@Test
	void testRetrieveBuyer() {
		
		log.info("=======> buyer : {} " , service.retrieveBuyer("P10101"));
		assertNotNull(service.retrieveBuyer("P10101"));
	}

}
