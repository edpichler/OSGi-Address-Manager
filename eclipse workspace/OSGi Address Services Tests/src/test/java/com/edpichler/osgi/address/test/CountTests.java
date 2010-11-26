/**
 * 
 */
package com.edpichler.osgi.address.test;

import com.edpichler.osgi.address.AddressServiceFactory;
import com.edpichler.osgi.address.IAddressService;
import com.edpichler.osgi.address.jpa.JPAUtil;

import junit.framework.TestCase;

/**
 * @author pichler
 * 
 */
public class CountTests extends TestCase {
	public void testCount() {
		IAddressService ser = AddressServiceFactory.createAddressService();
		ser.countCountry();
		ser.countCity();
		ser.countCountryState();
		ser.countAddress();
	}
}
