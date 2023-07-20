package kr.or.ddit.hakjum.vo;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "grade")
public class HakjumVO implements Serializable {
	@NotBlank
	private String grade;
	@NotNull
	@Min(0) 
	private Integer minPoint;
	@NotNull
	@Min(0)
	private Integer maxPoint;
}
