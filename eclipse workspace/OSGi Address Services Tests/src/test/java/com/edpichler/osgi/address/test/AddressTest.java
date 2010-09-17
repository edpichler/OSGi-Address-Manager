package com.edpichler.osgi.address.test;

import org.apache.felix.ipojo.junit4osgi.OSGiTestCase;

import com.edpichler.osgi.jpa.address.imp.Address;

public class AddressTest extends OSGiTestCase {
	
	public  void testFindAll(){				
		new Address().findAll();
	}
}