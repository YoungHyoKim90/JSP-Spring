package kr.or.ddit.props.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.PropertyVO;

class PropertyDAOImplTest {
	
	private PropertyDAO dao = new PropertyDAOImpl();

	@Test
	void testInsertProperty() {
		PropertyVO prop = new PropertyVO();
		prop.setPropertyName("nonCommitPN");
		prop.setPropertyValue("nonCommitPV");
//		prop.setDescription("nonCommitDS");
		int cnt = dao.insertProperty(prop);
		assertEquals(1, cnt);
	}

	@Test
	void testSelectProperty() {
		PropertyVO prop = dao.selectProperty("nonCommitPN");
		assertNotNull(prop);
	}

	@Test
	void testSelectProperties() {
		dao.selectProperties().forEach(System.out::println);
	}

	@Test
	void testUpdateProperty() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteProperty() {
		int cnt = dao.deleteProperty("nonCommitPN");
		assertNotEquals(0, cnt);
	}

}













