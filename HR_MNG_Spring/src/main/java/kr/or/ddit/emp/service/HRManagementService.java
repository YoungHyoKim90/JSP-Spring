package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.emp.vo.DepartmentVO;
import kr.or.ddit.emp.vo.JobHistoryVO;
import kr.or.ddit.emp.vo.JobVO;

public interface HRManagementService {
	public List<DepartmentVO> retrieveDepartments(String countryId);
	public List<JobVO> retrieveJobs();
	public List<JobHistoryVO> retrieveJobHistories(JobHistoryVO condition);
}
