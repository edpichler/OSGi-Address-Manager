package com.edpichler.osgi;

import com.edpichler.osgi.test.AddressTest;

import junit.framework.TestSuite;

public class Suite extends junit.framework.TestSuite {
	/**
	 * The skeleton of a JUnit test suite
	 */
	public static junit.framework.Test suite() {
		TestSuite suite = new TestSuite("The name of the test suite");
		suite.addTestSuite(AddressTest.class);
		return suite;
	}
}