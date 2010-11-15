package com.edpichler.osgi.address.test;

import com.edpichler.osgi.address.City;
import com.edpichler.osgi.address.Country;
import com.edpichler.osgi.address.CountryState;

public class TestUtil {

	public static City createCity() {
		City ci = new City();
		ci.setName("Name");
		ci.setState(createCountryState());
		return ci;
	}

	public static CountryState createCountryState() {

		CountryState co = new CountryState();
		co.setName("country state");
		co.setCountry(createCountry());
		return co;
	}

	public static Country createCountry() {
		Country cou = new Country();
		cou.setName("Brazil");
		cou.setSign("BR");
		return cou;
	}
}
