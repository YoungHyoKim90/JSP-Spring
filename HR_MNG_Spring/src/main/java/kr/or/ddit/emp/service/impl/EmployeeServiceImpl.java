package kr.or.ddit.emp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.emp.dao.EmployeeDAO;
import kr.or.ddit.emp.service.EmployeeService;
import kr.or.ddit.emp.vo.EmployeeVO;
import kr.or.ddit.emp.vo.Pagination;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private final EmployeeDAO empDAO;
	
	@Override
	public List<EmployeeVO> retrieveEmployees(Pagination<EmployeeVO> pagination) {
		int totalRecord = empDAO.selectTotalRecord(pagination);
		pagination.setTotalRecord(totalRecord);
		List<EmployeeVO> dataList = empDAO.selectEmployees(pagination);
		pagination.setDataList(dataList);
		return dataList;
	}

}
