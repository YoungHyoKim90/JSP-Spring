package kr.or.ddit.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import kr.or.ddit.validate.groups.loginGroup;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "proCd")
public class ProfessorVO implements Serializable {
	@NotBlank(groups = {loginGroup.class})
	private String proCd;
	@NotBlank
	private String proName;
	@NotBlank
	private String proTelno;
	@NotBlank(groups = {loginGroup.class})
	private String proDept;
}
