package kr.or.ddit.emp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.emp.dao.DepartmentDAO;
import kr.or.ddit.emp.dao.JobDAO;
import kr.or.ddit.emp.dao.JobHistoryDAO;
import kr.or.ddit.emp.service.HRManagementService;
import kr.or.ddit.emp.vo.DepartmentVO;
import kr.or.ddit.emp.vo.JobHistoryVO;
import kr.or.ddit.emp.vo.JobVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HRManagementServiceImpl implements HRManagementService {
	
	private final DepartmentDAO deptDAO;
	private final JobDAO jobDAO;
	private final JobHistoryDAO historyDAO;

	@Override
	public List<DepartmentVO> retrieveDepartments(String countryId) {
		return deptDAO.selectDepartments(countryId);
	}

	@Override
	public List<JobVO> retrieveJobs() {
		return jobDAO.selectJobs();
	}

	@Override
	public List<JobHistoryVO> retrieveJobHistories(JobHistoryVO condition) {
		return historyDAO.selectJobHistories(condition);
	}

}
