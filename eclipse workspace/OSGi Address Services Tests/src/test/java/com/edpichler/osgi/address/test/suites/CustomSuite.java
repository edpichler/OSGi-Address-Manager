package com.edpichler.osgi.address.test.suites;

import java.util.Map;

import junit.framework.TestSuite;

import com.edpichler.osgi.address.conf.ConfigurationServiceProvider;
import com.edpichler.osgi.address.test.AddressCrudTest;
import com.edpichler.osgi.address.test.AddressFindTest;
import com.edpichler.osgi.address.test.CityCrudTest;
import com.edpichler.osgi.address.test.CountTests;
import com.edpichler.osgi.address.test.CountryCrudTest;
import com.edpichler.osgi.address.test.CountryStateCrudTest;
import com.edpichler.osgi.address.test.JPAUtilTest;

public class CustomSuite extends junit.framework.TestSuite {
	/**
	 * The skeleton of a JUnit test suite
	 */
	@SuppressWarnings("unchecked")
	public static junit.framework.Test suite() {
		
//		// Same tests, but here with oracle
//		Map conf = ConfigurationServiceProvider.createOracleConfiguration(
//				"teste", "teste", "192.168.0.163", "xe", 1521);
//		ConfigurationServiceProvider.getAddressServicesConfiguration()
//				.setAddressServiceConfiguration(conf);	
		
		Map conf = ConfigurationServiceProvider.createDerbyConfiguration("any",
				"any", "AddTest");
		ConfigurationServiceProvider.getAddressServicesConfiguration()
				.setAddressServiceConfiguration(conf);

		TestSuite suite = new TestSuite(
				"OSGi Address Services Test Suite [Customize your database]");
		suite.addTestSuite(AddressCrudTest.class);
		suite.addTestSuite(AddressFindTest.class);
		suite.addTestSuite(CityCrudTest.class);
		suite.addTestSuite(CountryStateCrudTest.class);
		suite.addTestSuite(CountryCrudTest.class);
		suite.addTestSuite(JPAUtilTest.class);
		suite.addTestSuite(CountTests.class);
		return suite;
	}

}