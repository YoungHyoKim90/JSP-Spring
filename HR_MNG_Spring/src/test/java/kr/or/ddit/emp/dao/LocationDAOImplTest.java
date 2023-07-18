package kr.or.ddit.emp.dao;

import javax.inject.Inject;

import org.junit.Test;

import kr.or.ddit.AbstractModelLayerTest;

public class LocationDAOImplTest extends AbstractModelLayerTest{

	@Inject
	private LocationDAO dao;
	
	@Test
	public void testSelectRegions() {
		dao.selectRegions().stream()
					.forEach(System.out::println);
	}

	@Test
	public void testSelectCountries() {
		dao.selectCountries("1").stream()
			.forEach(System.out::println);
	}

	@Test
	public void testSelectLocations() {
		dao.selectLocations("UK").stream()
				.forEach(System.out::println);
	}

}
