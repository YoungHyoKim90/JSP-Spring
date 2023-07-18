package kr.or.ddit.emp.vo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="departmentId")
public class DepartmentVO {
	private Integer departmentId;
	private String departmentName;
	
	private EmployeeVO manager;
	private LocationVO location;
	
	private List<EmployeeVO> employees;
}
