package kr.or.ddit.emp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.ddit.emp.vo.EmployeeVO;
import kr.or.ddit.emp.vo.Pagination;

@Mapper
public interface EmployeeDAO {
	public int selectTotalRecord(Pagination<EmployeeVO> pagination);
	public List<EmployeeVO> selectEmployees(Pagination<EmployeeVO> pagination);
}
