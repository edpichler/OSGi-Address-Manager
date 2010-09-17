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
}