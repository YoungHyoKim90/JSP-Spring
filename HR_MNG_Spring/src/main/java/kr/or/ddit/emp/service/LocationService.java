package kr.or.ddit.emp.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.or.ddit.emp.vo.CountryVO;
import kr.or.ddit.emp.vo.LocationVO;
import kr.or.ddit.emp.vo.RegionVO;

public interface LocationService {
	public List<RegionVO> retrieveRegions();
	public List<CountryVO> retrieveCountries(@Param("regionId") String regionId);
	public List<LocationVO> retrieveLocations(@Param("countryId") String countryId);
}
