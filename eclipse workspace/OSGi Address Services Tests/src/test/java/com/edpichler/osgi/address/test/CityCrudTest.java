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

public class CityCrudTest extends OSGiTestCase {

	public void testPersist() {
		City city = newCity();
		IAddressService service = AddressServiceFactory.createAddressService();
		service.persist(city);

		assertNotNull(city.getId());
		CountryState state = city.getState();
		assertNotNull(state.getId());
		Country country = state.getCountry();
		assertNotNull(country.getId());

		List<Address> lista = service.findAllAddresses();
		assertTrue("It was not persisted", +lista.size() > 0);
	}

	/**
	 * @return
	 */
	private City newCity() {
		City city = TestUtil.createCity();
		city.setState(TestUtil.createCountryState());
		city.getState().setCountry(TestUtil.createCountry());
		return city;
	}

	public void testFindAll() {
		IAddressService service = AddressServiceFactory.createAddressService();
		City city = newCity();
		service.persist(city);

		assertNotNull(city.getId());

		List<Address> lista = service.findAllAddresses();
		assertTrue("It was not persisted", +lista.size() > 0);
	}

	public void testRemove() {

		City city = newCity();
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
			service.remove(city);
			fail("Cant delete because there are related elements");
			
		} catch (Exception e) {
			assertNotNull("must keep existing", service.findCityById(id));
		}


	}
	public void testRemoveCity() {

		City city = newCity();
		IAddressService service = AddressServiceFactory.createAddressService();
		
		service.persist(city);
		Long id = city.getId();
		assertNotNull(id);

		service.remove(city);
		
		assertNull("Can't find anything. ",service.findCityById(id));
	}


	public void testUpdate() {
		City city = newCity();

		IAddressService service = AddressServiceFactory.createAddressService();
		service.persist(city);

		final String novoNome = "cidade do sol";

		city.setName(novoNome);
		city.getState().setName(novoNome);

		service.merge(city);

		City saved = service.findCityById(city.getId());

		assertEquals("The streets are diferent!", novoNome, saved.getName());

		// the merge cannot occur in the related elements.
		CountryState cs = service.findCountryStateById(city.getState().getId());
		assertNotEquals("It cant be updated! ", novoNome, cs.getName());

	}

	public void testFindById() {
		City city = newCity();
		IAddressService service = AddressServiceFactory.createAddressService();
		service.persist(city);
		assertNotNull(city.getId());
	}
}