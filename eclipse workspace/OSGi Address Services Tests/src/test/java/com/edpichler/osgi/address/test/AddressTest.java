package com.edpichler.osgi.address.test;

import org.apache.felix.ipojo.junit4osgi.OSGiTestCase;

import com.edpichler.osgi.jpa.address.Address;

public class AddressTest extends OSGiTestCase {
	
	public  void testFind(){				
		new Address().find(2);
	}	
}