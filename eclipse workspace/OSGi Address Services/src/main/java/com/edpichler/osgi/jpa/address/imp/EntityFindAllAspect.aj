package com.edpichler.osgi.jpa.address.imp;

import java.util.List;

import javax.persistence.EntityManager;

import com.edpichler.osgi.jpa.address.conf.EntityManagerProvider;

/**
 * Aspect that persists, retrieve, update and delete an object
 * */
privileged aspect EntityFindAllAspect {

	// aux
	private static final EntityManager getEntityManager() {
		EntityManager ent = EntityManagerProvider.createEntityManager();
		return ent;
	}

	@SuppressWarnings("rawtypes")
	public static List<?> findAllObjects(Class o) {
		EntityManager entityManager = getEntityManager();		
		return entityManager.createQuery(
				"select o from " + o.getSimpleName() + " o").getResultList();
	}

	@SuppressWarnings("rawtypes")
	public static List<?> findEntriesObjects(Class o, int firstResult, int maxResult) {
		return getEntityManager()
				.createQuery("select o from " + o.getSimpleName() + " o")
				.setFirstResult(firstResult).setMaxResults(maxResult)
				.getResultList();
	}

	// findall
	@SuppressWarnings("unchecked")
	public List<Address> Address.findAll() {
		return (List<Address>) findAllObjects(Address.class);
	}

	@SuppressWarnings("unchecked")
	public List<Country> Country.findAll() {
		return (List<Country>) findAllObjects(Country.class);
	}

	@SuppressWarnings("unchecked")
	public List<City> City.findAll() {
		return (List<City>) findAllObjects(City.class);
	}

	@SuppressWarnings("unchecked")
	public List<CountryState> CountryState.findAll() {
		return (List<CountryState>) findAllObjects(CountryState.class);
	}

	// findentries
	@SuppressWarnings("unchecked")
	public List<Address> Address.findEntries(int firstResult, int maxResult) {
		return (List<Address>) findEntriesObjects(Address.class, firstResult,
				maxResult);
	}
	@SuppressWarnings("unchecked")
	public List<Country> Country.findEntries(int firstResult, int maxResult) {
		return (List<Country>) findEntriesObjects(Country.class, firstResult,
				maxResult);
	}
	@SuppressWarnings("unchecked")
	public List<City> City.findEntries(int firstResult, int maxResult) {
		return (List<City>) findEntriesObjects(City.class, firstResult,
				maxResult);
	}
	@SuppressWarnings("unchecked")
	public List<CountryState> CountryState.findEntries(int firstResult, int maxResult) {
		return (List<CountryState>) findEntriesObjects(CountryState.class, firstResult,
				maxResult);
	}
}