package kr.or.ddit.emp.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.emp.service.HRManagementService;
import kr.or.ddit.emp.vo.DepartmentVO;
import kr.or.ddit.emp.vo.JobHistoryVO;
import kr.or.ddit.emp.vo.JobVO;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GetHRInfomationController{
	@Inject
	private HRManagementService service;
	
	@RequestMapping("/departments")
	public List<DepartmentVO> handleDepartments(@RequestParam("where") String countryId) {
		return service.retrieveDepartments(countryId);
	}
	
	@RequestMapping("jobs")
	public List<JobVO> handleJobs(){
		return service.retrieveJobs();
	}
	
	@RequestMapping("/jobHistories")
	public List<JobHistoryVO> handleJobHistories(JobHistoryVO condition) {
		return service.retrieveJobHistories(condition);
	}
}
