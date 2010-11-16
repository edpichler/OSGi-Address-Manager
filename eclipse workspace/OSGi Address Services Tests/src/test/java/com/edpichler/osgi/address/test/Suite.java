package com.edpichler.osgi.address.test;

import java.util.Map;

import junit.framework.TestSuite;

import com.edpichler.osgi.address.conf.ConfigurationServiceProvider;

public class Suite extends junit.framework.TestSuite {
	/**
	 * The skeleton of a JUnit test suite
	 */
	public static junit.framework.Test suite() {
		 Map conf = ConfigurationServiceProvider.createOracleConfiguration(
		 "teste", "teste", "192.168.0.163", "xe", 1521);
		 ConfigurationServiceProvider.getAddressServicesConfiguration()
		 .setAddressServiceConfiguration(conf);

		TestSuite suite = new TestSuite("OSGi Address Services Test Suite");
		suite.addTestSuite(AddressCrudTest.class);
		suite.addTestSuite(AddressFindTest.class);
		suite.addTestSuite(CityCrudTest.class);
		suite.addTestSuite(CountryStateCrudTest.class);
		suite.addTestSuite(CountryCrudTest.class);
		suite.addTestSuite(JPAUtilTest.class);
		return suite;
	}
}