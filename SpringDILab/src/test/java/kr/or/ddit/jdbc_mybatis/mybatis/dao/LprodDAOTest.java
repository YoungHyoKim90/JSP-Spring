package kr.or.ddit.jdbc_mybatis.mybatis.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.jdbc_mybatis.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(locations = "file:src/main/resources/kr/or/ddit/jdbc_mybatis/*-context.xml")
class LprodDAOTest {

	@Inject
	private LprodDAO dao;
	

	@Test
	void test() {
		dao.selectLprodList().forEach(lprod->{
			log.info(lprod.toString());
			List<ProdVO> prodList = lprod.getProdList();
			if(! prodList.isEmpty())
				prodList.forEach(p->log.info("==============> {}", p));
		});
		
	}

}
