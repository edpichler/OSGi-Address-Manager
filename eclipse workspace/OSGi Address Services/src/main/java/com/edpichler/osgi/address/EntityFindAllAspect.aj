package com.edpichler.osgi.address;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.edpichler.osgi.address.jpa.AddressServicesImpl;
import com.edpichler.osgi.address.jpa.JPAUtil;

/**
 * Aspect that persists, retrieve, update and delete an object
 * */
privileged aspect EntityFindAllAspect {

	// aux
	private static final EntityManager createEntityManager() {
		EntityManager ent = JPAUtil.createEntityManager();
		return ent;
	}

	@SuppressWarnings("rawtypes")
	private static List<?> findAllObjects(Class o) {
		EntityManager entityManager = createEntityManager();
		Query query = entityManager.createQuery("select o from "
				+ o.getSimpleName() + " o");
		List resultList = query.getResultList();
		entityManager.close();
		entityManager = null;
		return resultList;
	}

	@SuppressWarnings("rawtypes")
	private static List<?> findEntriesObjects(Class o, int firstResult,
			int maxResult) {
		return createEntityManager().createQuery(
				"select o from " + o.getSimpleName() + " o").setFirstResult(
				firstResult).setMaxResults(maxResult).getResultList();
	}

	// findall
	@SuppressWarnings("unchecked")
	public List<Address> AddressServicesImpl.findAllAddresses() {
		return (List<Address>) findAllObjects(Address.class);
	}

	@SuppressWarnings("unchecked")
	public List<Country> AddressServicesImpl.findAllCountries() {
		return (List<Country>) findAllObjects(Country.class);
	}

	@SuppressWarnings("unchecked")
	public List<City> AddressServicesImpl.findAllCities() {
		return (List<City>) findAllObjects(City.class);
	}

	@SuppressWarnings("unchecked")
	public List<CountryState> AddressServicesImpl.findAllCountryStates() {
		return (List<CountryState>) findAllObjects(CountryState.class);
	}

	// findentries
	@SuppressWarnings("unchecked")
	public List<Address> AddressServicesImpl.findAddressEntries(int firstResult, int maxResult) {
		return (List<Address>) findEntriesObjects(Address.class, firstResult,
				maxResult);
	}

	@SuppressWarnings("unchecked")
	public List<Country> AddressServicesImpl.findCountryEntries(int firstResult, int maxResult) {
		return (List<Country>) findEntriesObjects(Country.class, firstResult,
				maxResult);
	}

	@SuppressWarnings("unchecked")
	public List<City> AddressServicesImpl.findCityEntries(int firstResult, int maxResult) {
		return (List<City>) findEntriesObjects(City.class, firstResult,
				maxResult);
	}

	@SuppressWarnings("unchecked")
	public List<CountryState> AddressServicesImpl.findCountryStateEntries(int firstResult,
			int maxResult) {
		return (List<CountryState>) findEntriesObjects(CountryState.class,
				firstResult, maxResult);
	}
}