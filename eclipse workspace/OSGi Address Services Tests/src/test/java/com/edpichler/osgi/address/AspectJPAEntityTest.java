package com.edpichler.osgi.address;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Test;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.edpichler.osgi.address.conf.AddressServicesConfiguration;
import com.edpichler.osgi.jpa.address.Address;

public class AspectJPAEntityTest {

	@Test
	public void testCreateEntityManager() {
		new Address().find(3);
		System.out.println("passou");
	}

	@Test
	public void testOverrideConf() {
		AddressServicesConfiguration.setPersistenceUnitProperties(null);
		new Address().find(3);
		System.out.println("passou");
	}

	@Test
	public void testOverrideConf2() {
		// <property name="javax.persistence.jdbc.url"
		// value="jdbc:derby:address;create=true" />

		Properties p = new Properties();
		p.put("javax.persistence.jdbc.url", "jdbc:derby:anydb;create=true");
		AddressServicesConfiguration.setPersistenceUnitProperties(p);
		new Address().find(3);
		System.out.println("passou");
	}	
}