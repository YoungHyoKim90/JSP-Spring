package kr.or.ddit.buyer.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.annotation.Resource;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import kr.or.ddit.buyer.vo.BuyerVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitWebConfig(locations ="file:src/main/resources/kr/or/ddit/spring/conf/*-context.xml")
class BuyerDAOTest {
	
	@Resource(name = "buyerDAO")
	private BuyerDAO dao;

	@Test
	void test() {
		BuyerVO buyer = dao.selectBuyer("P10101");
		log.info(" ======================= buyer : {}", buyer);
		assertNotNull(buyer);
	}

}
