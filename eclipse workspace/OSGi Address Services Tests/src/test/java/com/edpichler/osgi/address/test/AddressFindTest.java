package com.edpichler.osgi.address.test;

import java.util.List;

import org.apache.felix.ipojo.junit4osgi.OSGiTestCase;

import com.edpichler.osgi.jpa.address.imp.Address;

public class AddressFindTest extends OSGiTestCase {

	public void testFindById() {
		Address address = new Address();
		address.setLatitude((int) (Math.random() * 1000));
		address.persist();
		assertNotNull(address.getId());
//		assertEquals("Tye are not equals", address.getLatitude(), Address
//				.find(address.getId()).getLatitude());
	}
	
	public void testFindEntries() {
		for (int i = 0; i < 10; i++) {
			Address address = new Address();
			address.setLatitude(i);
			address.persist();	
		}
		List<Address> entries = Address.findEntries(2, 3); // 2nd till 5th
		assertEquals("Wrong quantity!", entries.size(), 3);
	}
	//TODO create findBy parameters.
	
	//TODO create interfaces
}