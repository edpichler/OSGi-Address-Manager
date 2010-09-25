package com.edpichler.osgi.address.test;

import java.util.List;

import org.apache.felix.ipojo.junit4osgi.OSGiTestCase;

import com.edpichler.osgi.address.Address;
import com.edpichler.osgi.address.AddressServiceFactory;
import com.edpichler.osgi.address.IAddressService;

public class AddressFindTest extends OSGiTestCase {

	public void testFindById() {
		Address address = new Address();
		address.setLatitude((int) (Math.random() * 1000));
		IAddressService service = AddressServiceFactory.createAddressService();
		service.persist(address);

		assertNotNull(address.getId());
		assertEquals("Tye are not equals", address.getLatitude(), service
				.findAddressById(address.getId()).getLatitude());
	}

	public void testFindEntries() {
		IAddressService service = AddressServiceFactory.createAddressService();

		for (int i = 0; i < 10; i++) {
			Address address = new Address();
			address.setLatitude(i);
			service.persist(address);

		}
		List<Address> entries = service.findAddressEntries(2, 3); // 2nd till
																	// 5th
		assertEquals("Wrong quantity!", entries.size(), 3);
	}
	// TODO create findBy parameters.
}