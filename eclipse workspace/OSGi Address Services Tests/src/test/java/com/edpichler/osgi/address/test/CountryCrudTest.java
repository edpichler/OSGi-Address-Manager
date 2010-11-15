package com.edpichler.osgi.address.test;

import java.util.List;

import org.apache.felix.ipojo.junit4osgi.OSGiTestCase;

import com.edpichler.osgi.address.Address;
import com.edpichler.osgi.address.AddressServiceFactory;
import com.edpichler.osgi.address.City;
import com.edpichler.osgi.address.Country;
import com.edpichler.osgi.address.CountryState;
import com.edpichler.osgi.address.IAddressService;
import com.edpichler.osgi.address.test.util.TestUtil;

public class CountryCrudTest extends OSGiTestCase {

	/**
	 * @return
	 */
	private City newCity() {
		City city = TestUtil.createCity();
		city.setState(TestUtil.createCountryState());
		city.getState().setCountry(TestUtil.createCountry());
		return city;
	}

	public void testRemove() {

		City city = newCity();
		IAddressService service = AddressServiceFactory.createAddressService();

		Address ad = new Address();
		ad.setStreet("rua");
		ad.setCity(city);

		service.persist(ad);
		Long id = city.getState().getCountry().getId();
		assertNotNull(id);
		assertNotNull(ad.getId());

		// must delete childs, but no other related instances, as javadoc
		// documentation explain

		try {
			service.remove(city.getState().getCountry());
			fail("Cant delete because there are related elements");

		} catch (Exception e) {
			assertNotNull("must keep existing", service.findCountryById(id));
		}

	}

	public void testRemoveCountry() {

		City city = newCity();
		IAddressService service = AddressServiceFactory.createAddressService();

		service.persist(city);
		Long id = city.getId();
		assertNotNull(id);

		service.remove(city);
		service.remove(city.getState());
		service.remove(city.getState().getCountry());
		assertNull("Can't find anything. ", service.findCountryById(city
				.getState().getCountry().getId()));
	}

}