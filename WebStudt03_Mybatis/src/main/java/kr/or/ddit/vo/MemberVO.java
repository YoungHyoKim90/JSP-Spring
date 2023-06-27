package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@EqualsAndHashCode(of = "memId")
@ToString(exclude = {"memPass","memRegno1", "memRegno2" })
public class MemberVO implements Serializable{

	private String memId;
	@JsonIgnore
	private transient String memPass;
	private String memName;
	private transient String memRegno1;
	private transient String memRegno2;
	private Date memBir;
	private String memZip;
	private String memAdd1;
	private String memAdd2;
	private String memHometel;
	private String memComtel;
	private String memHp;
	private String memMail;
	private String memJob;
	private String memLike;
	private String memMemorial;
	private Date memMemorialday;
	private Integer memMileage;
	private String memDelete;
	
}

/*
 * transient => 직렬화는 제외, 마샬링은 제외 아님! 비밀번호 보안!
 * 	@JsonIgnore => 마샬링 제외!
 */ 
