package com.edpichler.osgi.address.test;

import java.util.List;
import java.util.Map;

import org.apache.felix.ipojo.junit4osgi.OSGiTestCase;

import com.edpichler.osgi.address.Address;
import com.edpichler.osgi.address.AddressServiceFactory;
import com.edpichler.osgi.address.City;
import com.edpichler.osgi.address.Country;
import com.edpichler.osgi.address.CountryState;
import com.edpichler.osgi.address.IAddressService;
import com.edpichler.osgi.address.conf.ConfigurationServiceProvider;
import com.edpichler.osgi.address.test.util.TestUtil;

public class AddressFindTest extends OSGiTestCase {

//	public static void main(String[] args) {		
//		Map conf = ConfigurationServiceProvider.createOracleConfiguration(
//				"user", "password", "192.168.0.163", "xe", 1521);
//		
//		ConfigurationServiceProvider.getAddressServicesConfiguration()
//				.setAddressServiceConfiguration(conf);
//	}
	
	
	//TODO Obrigar DERBY CONFIGURATION OU ORACLE CONFIGURATION.
	
	public void testFindById() {
		Address address = new Address();
		address.setCity(TestUtil.createCity());
		address.setLatitude((int) (Math.random() * 1000));
		IAddressService service = AddressServiceFactory.createAddressService();
		service.persist(address);

		assertNotNull(address.getId());
		assertEquals("Tye are not equals", address.getLatitude(), service
				.findAddressById(address.getId()).getLatitude());
		
		//test the city
		City city = address.getCity();
		assertNotNull(city);
		assertNotNull(city.getId());
		
		//test the CountryState
		CountryState state = city.getState();
		assertNotNull(state);
		assertNotNull(state.getId());
		
		//test country
		Country country = state.getCountry();
		assertNotNull(country);
		assertNotNull(country.getId());
	}

	public void testFindEntries() {
		IAddressService service = AddressServiceFactory.createAddressService();

		for (int i = 0; i < 10; i++) {
			Address address = new Address();
			address.setLatitude(i);
			address.setCity(TestUtil.createCity());
			service.persist(address);

		}
		List<Address> entries = service.findAddressEntries(2, 3); // 2nd till
		// 5th
		assertEquals("Wrong quantity!", entries.size(), 3);
	}
	// TODO create findBy parameters.
}