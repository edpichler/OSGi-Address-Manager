package com.edpichler.osgi.address;

import java.util.List;

/**
 * Class exposing the services
 * */
public interface IAddressService {
	/**
	 * Persist the object and all the child. Ex.: Saving a {@link Address}
	 * instance, the {@link City} instance, if their is, will be saved too, as
	 * well the other related instances {@link CountryState}, {@link Country} .
	 */

	public void persist(Object o);

	/**
	 * Remove the object.
	 * */
	public void remove(Address o);

	/**
	 * Remove the object and all the aggregated instances. Ex.: If you remove a
	 * {@link Country} instance, the {@link CountryState}, {@link City} and
	 * {@link Address} will also be removed from database database.
	 * */
	public void remove(Country o);

	/**
	 * Remove the object and all the aggregated instances. Ex.: If you remove a
	 * {@link CountryState} instance, the {@link City} and {@link Address} will
	 * also be removed from database database.
	 * */
	public void remove(CountryState o);

	/**
	 * Remove the object and all the aggregated instances. Ex.: If you remove a
	 * {@link City} instance, the {@link Address} related instances will be also
	 * removed from database
	 * */

	public void remove(City o);

	/**
	 * Merge just the object passed by parameter
	 * */
	public void merge(Object o);

	
	/**
	 * Find by the ID
	 * @param id
	 * @return {@link Address}
	 */
	@SuppressWarnings("unchecked")
	public Address findAddressById(long id);

	public Country findCountryById(long id);

	public City findCityById(long id);

	public CountryState findCountryStateById(long id);

	public List<Address> findAllAddresses();

	public List<Address> findAddressEntries(int firstResult, int maxResult);

	public List<City> findCityEntries(int firstResult, int maxResult);

}
