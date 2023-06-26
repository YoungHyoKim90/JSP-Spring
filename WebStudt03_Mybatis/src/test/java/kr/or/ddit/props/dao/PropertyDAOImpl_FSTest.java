package kr.or.ddit.props.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.PropertyVO;

class PropertyDAOImpl_FSTest {
	
	private PropertyDAO dao = new PropertyDAOImpl_FS();

	@Test
	@Order(1) 
	void testInsertProperty() {
		
		PropertyVO prop = new PropertyVO();
		
		prop.setPropertyName("prop2");
		prop.setPropertyValue("prop value 2");
		int count = dao.insertProperty(prop);
		assertEquals(1, count);
	}

	@Test
	@Order(2)
	void testSelectProperties() {

	List<PropertyVO> proplList = dao.selectProperties();
	assertNotNull(proplList);
	proplList.forEach(System.out ::println);
	
	}

}
