package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Domain Layer - ValueObject, DataTransferObject, JavaBean, Model
 * 
 * 	A a = new A();
 * 	A b = new A();
 *  a==b (주소 비교) , a.equals(b) (주소 비교, 상태 비교)
 *
 */
//@Getter
//@Setter
//@ToString
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="propertyName")
public class PropertyVO implements Serializable{
	
	private String propertyName;
	private String propertyValue;
	private String description;
	
}




















