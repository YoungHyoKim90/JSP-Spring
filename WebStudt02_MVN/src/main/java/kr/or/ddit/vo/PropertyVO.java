package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.Objects;

/**
 * Domain Layer - ValueObject, DataTransferObject, JavaBean, Model
 * 
 * 	A a = new A();
 * 	A b = new A();
 *  a==b (주소 비교) , a.equals(b) (주소 비교, 상태 비교)
 *
 */
public class PropertyVO implements Serializable{
	private String propertyName;
	private String propertyValue;
	
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	@Override
	public String toString() {
		return "PropertyVO [propertyName=" + propertyName + ", propertyValue=" + propertyValue + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(propertyName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropertyVO other = (PropertyVO) obj;
		return Objects.equals(propertyName, other.propertyName);
	}
	
	
}




















