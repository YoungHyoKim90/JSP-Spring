package kr.or.ddit.board.vo;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="boNo")
public class FreeboardVO {
	private long rnum;
	@NotNull
	private Integer boNo;
	@NotBlank
	private String boTitle;
	@NotBlank
	private String boWriter;
	@NotBlank
	private String boIp;
	@Email
	private String boMail;
	@NotBlank
	private String boPass;
	private String boContent;
	private LocalDate boDate;
	private Integer boHit;
}
