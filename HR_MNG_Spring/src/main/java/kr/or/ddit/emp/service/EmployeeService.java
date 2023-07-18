package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.emp.vo.EmployeeVO;
import kr.or.ddit.emp.vo.Pagination;

public interface EmployeeService {
	public List<EmployeeVO> retrieveEmployees(Pagination<EmployeeVO> pagination);
}
