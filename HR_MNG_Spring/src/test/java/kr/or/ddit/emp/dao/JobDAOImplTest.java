package kr.or.ddit.emp.dao;

import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.junit.Test;

import kr.or.ddit.AbstractModelLayerTest;

public class JobDAOImplTest extends AbstractModelLayerTest{

	@Inject
	private JobDAO dao;
	
	@Test
	public void testInsertJob() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectJobs() {
		dao.selectJobs().stream().forEach(System.out::println);
	}

	@Test
	public void testSelectJob() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateJob() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteJob() {
		fail("Not yet implemented");
	}

}
