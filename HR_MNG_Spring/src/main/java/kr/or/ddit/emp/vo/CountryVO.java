package kr.or.ddit.emp.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="countryId")
public class CountryVO  implements Serializable{
	private String countryId;
	private String countryName;
	
	private RegionVO region;
	
	private List<LocationVO> locations;
}
