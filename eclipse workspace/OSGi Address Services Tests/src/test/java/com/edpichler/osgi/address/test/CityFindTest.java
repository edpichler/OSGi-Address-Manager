package com.edpichler.osgi.address.test;

import java.util.List;

import org.apache.felix.ipojo.junit4osgi.OSGiTestCase;

import com.edpichler.osgi.address.Address;
import com.edpichler.osgi.address.AddressServiceFactory;
import com.edpichler.osgi.address.City;
import com.edpichler.osgi.address.IAddressService;

public class CityFindTest extends OSGiTestCase {

	public void testFindById() {
		City city = new City();
		city.setName("Blumenau");
		IAddressService service = AddressServiceFactory.createAddressService();
		service.persist(city);

		assertNotNull(city.getId());
		assertEquals("Tye are not equals", city.getName(), service
				.findCityById(city.getId()).getName());
	}

	public void testFindEntries() {
		IAddressService service = AddressServiceFactory.createAddressService();

		for (int i = 0; i < 10; i++) {
			City cit = new City();
			cit.setName("" + i);
			service.persist(cit);

		}
		List<City> entries = service.findCityEntries(2, 3); // 2nd till
																	// 5th
		assertEquals("Wrong quantity!", entries.size(), 3);
	}
	// TODO create findBy parameters.
}