package kr.or.ddit.student.vo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(of = "studNo")
@ToString(exclude = "studIdno")
public class StudentVO implements Serializable {
	@NotBlank
	private String studNo;
	@NotBlank
	private String studName;
	@NotBlank
	private String studTelno;
	@NotBlank
	private String studAdd;
	@NotBlank
	@JsonIgnore
	private transient String studIdno;
}
