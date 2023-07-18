package kr.or.ddit.emp.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="regionId")
public class RegionVO implements Serializable{
	private String regionId;
	private String regionName;
	
	private List<CountryVO> countries;
}
