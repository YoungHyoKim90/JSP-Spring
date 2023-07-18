package kr.or.ddit.emp.dao;

import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.junit.Test;

import kr.or.ddit.AbstractModelLayerTest;

public class DepartmentDAOImplTest extends AbstractModelLayerTest{

	@Inject
	private DepartmentDAO dao;
	
	@Test
	public void testInsertDepartment() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectDepartments() {
		dao.selectDepartments(null).stream().forEach(System.out::println);
	}

	@Test
	public void testSelectDepartment() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateDepartment() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteDepartment() {
		fail("Not yet implemented");
	}

}
