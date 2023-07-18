package kr.or.ddit.emp.vo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="locationId")
public class LocationVO  implements Serializable{
	private Integer locationId;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;
	
	private CountryVO country;
}
