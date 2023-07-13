package kr.or.ddit.vo;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "subCd")
public class SubjectVO implements Serializable {
	@NotBlank
	private String subCd;
	@NotBlank
	private String subName;
	@NotNull
	@Min(0)
	private Integer subPoint;
}
