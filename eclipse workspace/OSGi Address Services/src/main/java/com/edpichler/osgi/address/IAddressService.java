package com.edpichler.osgi.address;

import java.util.List;

/**
 * Class exposing the services
 * */
public interface IAddressService {
	public abstract void persist(Object o);

	public abstract void remove(Address o);

	public abstract void remove(Country o);

	public abstract void remove(CountryState o);

	public abstract void remove(City o);

	public abstract void merge(Object o);

	// FIND BY ID
	@SuppressWarnings("unchecked")
	public abstract Address findAddressById(long id);

	public abstract Country findCountryById(long id);

	public abstract City findCityById(long id);

	public abstract CountryState findCountryStateById(long id);
	
	public abstract List<Address> findAllAddresses();

	public abstract List<Address> findAddressEntries(int firstResult, int maxResult);
	public abstract List<City> findCityEntries(int firstResult, int maxResult);
		 
}
