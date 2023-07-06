package kr.or.ddit.jdbc_mybatis;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import kr.or.ddit.jdbc_mybatis.mybatis.dao.PropertyDAO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringJUnitConfig(locations = "file:src/main/resources/kr/or/ddit/jdbc_mybatis/*-context.xml")
class SqlSessionFactoryTest {
	@Inject
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Inject
	private PropertyDAO dao;
	
	@Test
	void testTemplate() {
//		PropertyDAO mapper = sqlSessionTemplate.getMapper(PropertyDAO.class);
		dao.selectPropertyList().forEach(p->log.info(p.toString()));
	}

	@Test
	void test() {
		log.info("주입 객체 : {}", sqlSessionFactory);
		
	}

}



















