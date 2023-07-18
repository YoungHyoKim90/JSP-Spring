package kr.or.ddit.emp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.emp.dao.LocationDAO;
import kr.or.ddit.emp.service.LocationService;
import kr.or.ddit.emp.vo.CountryVO;
import kr.or.ddit.emp.vo.LocationVO;
import kr.or.ddit.emp.vo.RegionVO;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {
	private final LocationDAO locationDAO;

	@Override
	public List<RegionVO> retrieveRegions() {
		return locationDAO.selectRegions();
	}

	@Override
	public List<CountryVO> retrieveCountries(String regionId) {
		return locationDAO.selectCountries(regionId);
	}

	@Override
	public List<LocationVO> retrieveLocations(String countryId) {
		return locationDAO.selectLocations(countryId);
	}
}
