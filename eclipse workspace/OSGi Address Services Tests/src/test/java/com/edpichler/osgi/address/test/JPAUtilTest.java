/**
 * 
 */
package com.edpichler.osgi.address.test;

import java.util.HashMap;

import junit.framework.TestCase;

import com.edpichler.osgi.address.conf.ConfigurationServiceProvider;
import com.edpichler.osgi.address.jpa.JPAUtil;

/**
 * @author pichler
 * 
 */
public class JPAUtilTest extends TestCase {

	/**
	 * Test method for
	 * {@link com.edpichler.osgi.address.jpa.JPAUtil#createEntityManager()}.
	 */
	public void testCreateEntityManager() {
		assertNotNull(JPAUtil.createEntityManager());
	}

	/**
	 * Test method for
	 * {@link com.edpichler.osgi.address.jpa.JPAUtil#setAddressServiceConfiguration(java.util.Map)}
	 * .
	 */
	@SuppressWarnings("unchecked")
	public void testSetAddressServiceConfiguration() {

		try {
			ConfigurationServiceProvider.getAddressServicesConfiguration()
					.setAddressServiceConfiguration(null);
			fail("An exception should be throwed");
		} catch (IllegalStateException e) {
			assertTrue(true);
		}
	}

}
