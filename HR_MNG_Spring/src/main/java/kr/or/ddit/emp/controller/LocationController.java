package kr.or.ddit.emp.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.emp.service.LocationService;
import kr.or.ddit.emp.vo.CountryVO;
import kr.or.ddit.emp.vo.LocationVO;
import kr.or.ddit.emp.vo.RegionVO;

@RestController
@RequestMapping(value="/loc", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class LocationController{
	@Inject
	private LocationService service;
	
	@RequestMapping("regions")
	public List<RegionVO> handleRegion(){
		return service.retrieveRegions();
	}
	
	@RequestMapping("countries")
	public List<CountryVO>handleCountry(@RequestParam("where") String regionId){
		return service.retrieveCountries(regionId);
	}
	
	@RequestMapping("locations")
	public List<LocationVO> handleLocation(@RequestParam("where") String countryId){
		return service.retrieveLocations(countryId);
	}
	
}


















