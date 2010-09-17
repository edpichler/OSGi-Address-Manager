package com.edpichler.osgi.jpa.address.imp;

import javax.persistence.EntityManager;

import com.edpichler.osgi.jpa.address.conf.EntityManagerProvider;

/**
 * Aspect that persists, retrieve, update and delete an object
 * */
privileged aspect EntityCountAspect {

	private static final EntityManager getEntityManager() {
		EntityManager ent = EntityManagerProvider.createEntityManager();
		return ent;
	}

	public long Address.countAddress() {
		return count(Address.class);
	}

	public long City.countAddress() {
		return count(City.class);
	}

	public long Country.countAddress() {
		return count(Country.class);
	}

	public long CountryState.countAddress() {
		return count(CountryState.class);
	}

	public static long count(Class o) {
		return (Long) getEntityManager().createQuery(
				"select count(o) from " + o.getSimpleName() + " o")
				.getSingleResult();
	}
}
