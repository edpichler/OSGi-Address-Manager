package com.edpichler.osgi.address.test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import oracle.jdbc.driver.OracleDriver;

import com.edpichler.osgi.address.conf.ConfigurationServiceProvider;
import com.edpichler.osgi.address.conf.IAddressServicesConfiguration;

import junit.framework.TestSuite;

public class Suite extends junit.framework.TestSuite {
	/**
	 * The skeleton of a JUnit test suite
	 */
	public static junit.framework.Test suite() {
		setConf();

		TestSuite suite = new TestSuite("OSGi Address Services Test Suite");
		suite.addTestSuite(AddressCrudTest.class);
		suite.addTestSuite(AddressFindTest.class);
		suite.addTestSuite(CityCrudTest.class);
		suite.addTestSuite(CountryStateCrudTest.class);
		suite.addTestSuite(CountryCrudTest.class);
		suite.addTestSuite(JPAUtilTest.class);
		return suite;
	}

	/**
	 * Setting configuration.
	 */
	@SuppressWarnings("unchecked")
	private static void setConf() {

		IAddressServicesConfiguration confPro = ConfigurationServiceProvider
				.getAddressServicesConfiguration();
		
		Map map = new HashMap<String, String>();
		map.put("javax.persistence.jdbc.driver",
				"oracle.jdbc.OracleDriver");
//		map.put("javax.persistence.jdbc.username", "teste");
//		map.put("javax.persistence.jdbc.password", "teste");
		map.put("javax.persistence.jdbc.user", "teste");
		map.put("javax.persistence.jdbc.password", "teste");
		map.put("javax.persistence.jdbc.url", "jdbc:oracle:thin:@192.168.0.163:1521:XE");
		map.put("eclipselink.target-database","Oracle");
//		org.eclipse.persistence.platform.database.oracle.OraclePlatform
		confPro.setAddressServiceConfiguration(map);

	}
}