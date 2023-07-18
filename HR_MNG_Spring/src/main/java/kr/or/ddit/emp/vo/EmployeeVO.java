package kr.or.ddit.emp.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="employeeId")
public class EmployeeVO {
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String empName;
	private String email;
	private String phoneNumber;
	@JsonFormat(shape = Shape.STRING)
	private LocalDate hireDate;
	@JsonFormat(shape = Shape.STRING)
	private LocalDate retireDate;
	
	private Integer salary;
	private Integer commissionPct;
	
	private JobVO job;
	private EmployeeVO manager;
	private DepartmentVO department;
}
