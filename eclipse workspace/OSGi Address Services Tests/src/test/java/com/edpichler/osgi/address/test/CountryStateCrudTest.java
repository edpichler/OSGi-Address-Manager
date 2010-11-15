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

public class CountryStateCrudTest extends OSGiTestCase {

	

	public void testRemove() {

		City city = TestUtil.createCity();
		IAddressService service = AddressServiceFactory.createAddressService();

		Address ad = new Address();
		ad.setStreet("rua");
		ad.setCity(city);

		service.persist(ad);
		Long id = city.getId();
		assertNotNull(id);
		assertNotNull(ad.getId());

		// must delete childs, but no other related instances, as javadoc
		// documentation explain

		try {
			service.remove(city.getState() );
			fail("Cant delete because there are related elements");

		} catch (Exception e) {
			assertNotNull("must keep existing", service.findCityById(id));
		}

	}

	public void testRemoveCountryState() {

		City city = TestUtil.createCity();
		IAddressService service = AddressServiceFactory.createAddressService();

		service.persist(city);
		Long id = city.getId();
		assertNotNull(id);

		service.remove(city);
		service.remove(city.getState());

		assertNull("Can't find anything. ", service.findCountryById(city.getState().getId()));
	}

}