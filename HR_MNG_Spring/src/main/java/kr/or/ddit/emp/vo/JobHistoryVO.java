package kr.or.ddit.emp.vo;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of= {"employee", "startDate"})
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Builder
public class JobHistoryVO {
	private EmployeeVO employee;
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	private JobVO job;
	private DepartmentVO department;
}
