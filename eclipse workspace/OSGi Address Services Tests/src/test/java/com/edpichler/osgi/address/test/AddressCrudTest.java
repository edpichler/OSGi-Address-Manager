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

public class AddressCrudTest extends OSGiTestCase {

	public void testPersist() {
		Address address = new Address();
		address.setStreet("Rua");
		address.setCity(TestUtil.createCity());
		IAddressService service = AddressServiceFactory.createAddressService();
		service.persist(address);

		assertNotNull(address.getId());
		City city = address.getCity();
		assertNotNull(city.getId());
		CountryState state = city.getState();
		assertNotNull(state.getId());
		Country country = state.getCountry();
		assertNotNull(country.getId());

		List<Address> lista = service.findAllAddresses();
		assertTrue("It was not persisted", +lista.size() > 0);
	}

	// TODO PASSAR PARAMETRO PARA RECRIAR O BANCO TODA VEZ QUE INICIA TESTES.
	// TODO CRIAR BANCO COM SUFIXO TEMP PARA NAO TER RISCO DE APAGAR EM PRODU��O
	// TODO CODE COVERAGE AT 80%

	public void testFindAll() {
		Address address = new Address();
		address.setCity(TestUtil.createCity());
		address.setStreet("Rua etc");
		IAddressService service = AddressServiceFactory.createAddressService();
		service.persist(address);

		assertNotNull(address.getId());

		List<Address> lista = service.findAllAddresses();
		assertTrue("It was not persisted", +lista.size() > 0);
	}

	public void testRemoveAddress() {
		Address address = new Address();
		address.setStreet("Rua");
		City city = TestUtil.createCity();
		address.setCity(city);
		IAddressService service = AddressServiceFactory.createAddressService();

		service.persist(address);

		assertNotNull(address.getId());
		service.remove(address);
		assertNull("It was not removed", service.findAddressById(address
				.getId()));

		// city can't be deleted
		assertNotNull("city can't be deleted", service.findCityById(city
				.getId()));
	}

	public void testUpdate() {
		Address address = new Address();
		address.setStreet("Rua");
		address.setCity(TestUtil.createCity());

		IAddressService service = AddressServiceFactory.createAddressService();
		service.persist(address);

		assertNotNull(address.getId());

		String novaRua = "Rua das Hortênsias";

		List<Address> lista = service.findAllAddresses();
		assertTrue("It was not persisted", +lista.size() > 0);

		address.setStreet(novaRua);
		final String outroNome = "outra cidade";
		address.getCity().setName(outroNome);
		service.merge(address);

		Address adrSaved = service.findAddressById(address.getId());
		final String ruaSalva = adrSaved.getStreet();

		assertEquals("The streets are diferent!", novaRua, ruaSalva);

		// o merge não pode ocorrer na cidade, e sim somente no objeto endereço
		City city = service.findCityById(adrSaved.getCity().getId());
		assertNotEquals("It cant be merged! ", outroNome, city.getName());

	}

	public void testFindById() {
		Address address = new Address();
		address.setCity(TestUtil.createCity());
		address.setStreet("Back Street");
		address.setCity(TestUtil.createCity());
		IAddressService service = AddressServiceFactory.createAddressService();
		service.persist(address);

		assertNotNull(address.getId());
		Address adrSaved = service.findAddressById(address.getId());
		assertNotNull("Can't find!", adrSaved);
		assertNotNull(adrSaved.getCity());
	}
}