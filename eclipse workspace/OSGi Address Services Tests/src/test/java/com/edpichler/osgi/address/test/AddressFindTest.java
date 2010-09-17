package com.edpichler.osgi.address.test;

import java.util.List;

import org.apache.felix.ipojo.junit4osgi.OSGiTestCase;

import com.edpichler.osgi.jpa.address.imp.Address;

public class AddressFindTest extends OSGiTestCase {

	public void testFindById() {
		Address address = new Address();
		address.setLatitutde((int) (Math.random() * 1000));
		address.persist();
		assertNotNull(address.getId());
		assertEquals("Tye are not equals", address.getLatitutde(), Address
				.find(address.getId()).getLatitutde());
	}
	
	public void testFindEntries() {
		for (int i = 0; i < 10; i++) {
			Address address = new Address();
			address.setLatitutde(i);
			address.persist();	
		}
		List<Address> entries = Address.findEntries(2, 3); // 2nd till 5th
		assertEquals("Wrong quantity!", entries.size(), 3);
	}
}