package kr.or.ddit.teaching.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import kr.or.ddit.professor.vo.ProfessorVO;
import kr.or.ddit.subject.vo.SubjectVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = {"subCd", "proCd"})
public class TeachingVO implements Serializable {
	@NotBlank
	private String teaRoom;
	@NotBlank
	private String teaTime;
	@NotBlank
	private String subCd;
	private SubjectVO subject; // has a 관계 (1:1)
	@NotBlank
	private String proCd;
	private ProfessorVO professor; // has a 관계 (1:1)
}
