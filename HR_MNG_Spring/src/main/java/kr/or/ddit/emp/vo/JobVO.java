package kr.or.ddit.emp.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="jobId")
public class JobVO {
	private String jobId;
	private String jobTitle;
	private Integer minSalary;
	private Integer maxSalary;
}
