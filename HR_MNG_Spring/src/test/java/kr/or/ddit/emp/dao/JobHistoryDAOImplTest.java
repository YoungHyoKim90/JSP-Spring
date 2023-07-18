package kr.or.ddit.emp.dao;

import static org.junit.Assert.fail;

import java.time.LocalDate;

import javax.inject.Inject;

import org.junit.Test;

import kr.or.ddit.AbstractModelLayerTest;
import kr.or.ddit.emp.vo.JobHistoryVO;

public class JobHistoryDAOImplTest extends AbstractModelLayerTest{
	
	@Inject
	private JobHistoryDAO dao;

	@Test
	public void testInsertJobHistory() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectJobHistories() {
		JobHistoryVO condition = JobHistoryVO.builder()
									.startDate(LocalDate.parse("2005-01-01"))
									.endDate(LocalDate.parse("2007-12-31"))
									.build();
		dao.selectJobHistories(condition).stream().forEach(System.out::println);
	}

}
