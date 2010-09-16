package com.edpichler.osgi;

import com.edpichler.osgi.test.AddressTest;

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