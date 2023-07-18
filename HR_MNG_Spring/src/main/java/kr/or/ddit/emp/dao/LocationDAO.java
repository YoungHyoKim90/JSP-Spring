package kr.or.ddit.emp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.emp.vo.CountryVO;
import kr.or.ddit.emp.vo.LocationVO;
import kr.or.ddit.emp.vo.RegionVO;
@Mapper
public interface LocationDAO {
	public List<RegionVO> selectRegions();
	public List<CountryVO> selectCountries(@Param("regionId") String regionId);
	public List<LocationVO> selectLocations(@Param("countryId") String countryId);
}
