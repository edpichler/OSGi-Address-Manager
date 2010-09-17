package com.edpichler.osgi.jpa.address.imp;

import java.util.List;

import javax.persistence.EntityManager;

import com.edpichler.osgi.jpa.address.conf.EntityManagerProvider;

/**
 * Aspect that persists, retrieve, update and delete an object
 * */
privileged aspect EntityFindByIdAspect {

	private static final EntityManager getEntityManager() {
		EntityManager ent = EntityManagerProvider.createEntityManager();
		return ent;
	}

	@SuppressWarnings("unchecked")
	public static Address Address.find(long id) {
		return (Address) findById(Address.class, id);
	}

	@SuppressWarnings("unchecked")
	public Country Country.find(long id) {
		return (Country) findById(Country.class, id);
	}

	@SuppressWarnings("unchecked")
	public City City.find(long id) {
		return (City) findById(City.class, id);
	}

	@SuppressWarnings("unchecked")
	public CountryState CountryState.find(long id) {
		return (CountryState) findById(CountryState.class, id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object findById(Class o, long id) {
		return getEntityManager().find(o, id);
	}
}
