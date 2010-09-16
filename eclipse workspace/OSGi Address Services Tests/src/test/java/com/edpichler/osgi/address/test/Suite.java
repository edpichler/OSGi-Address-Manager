package com.edpichler.osgi.address.test;


import junit.framework.TestSuite;

public class Suite extends junit.framework.TestSuite {
	/**
	 * The skeleton of a JUnit test suite
	 */
	public static junit.framework.Test suite() {
		TestSuite suite = new TestSuite("Address Services Test Suite");
		suite.addTestSuite(AddressTest.class);
		return suite;
	}
}