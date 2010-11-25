package com.edpichler.osgi.address.test.suites;

import java.util.Map;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.edpichler.osgi.address.conf.ConfigurationServiceProvider;
import com.edpichler.osgi.address.test.AddressCrudTest;
import com.edpichler.osgi.address.test.AddressFindTest;
import com.edpichler.osgi.address.test.CityCrudTest;
import com.edpichler.osgi.address.test.CountryCrudTest;
import com.edpichler.osgi.address.test.CountryStateCrudTest;
import com.edpichler.osgi.address.test.JPAUtilTest;

public class OracleSuite extends junit.framework.TestSuite {
	/**
	 * The skeleton of a JUnit test suite
	 */
	public static junit.framework.Test suite() {

		// Same tests, but here with oracle
		Map conf = ConfigurationServiceProvider.createOracleConfiguration(
				"teste", "teste", "192.168.0.163", "xe", 1521);
		ConfigurationServiceProvider.getAddressServicesConfiguration()
				.setAddressServiceConfiguration(conf);

		TestSuite suite = (TestSuite) ApacheDerbySuite.suite();
		suite.setName("OSGi Address Services Test Suite [Oracle 10g]");
		return suite;

	}
}