package kr.or.ddit.emp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.emp.vo.DepartmentVO;

@Mapper
public interface DepartmentDAO {
	public int insertDepartment(DepartmentVO department);
	public List<DepartmentVO> selectDepartments(@Param("countryId") String countryId);
	public DepartmentVO selectDepartment(@Param("departmentId") String departmentId);
	public int updateDepartment(DepartmentVO department);
	public int deleteDepartment(@Param("departmentId") String departmentId);
}
