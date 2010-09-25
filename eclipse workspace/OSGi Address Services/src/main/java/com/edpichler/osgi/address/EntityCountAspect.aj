package com.edpichler.osgi.address;

import javax.persistence.EntityManager;
import com.edpichler.osgi.address.jpa.*;
import com.edpichler.osgi.address.jpa.JPAUtil;

/**
 * Aspect that persists, retrieve, update and delete an object
 * */
privileged aspect EntityCountAspect {

	private static final EntityManager getEntityManager() {
		EntityManager ent = JPAUtil.createEntityManager();
		return ent;
	}

	public long AddressServicesImpl.countAddress() {
		return count(Address.class);
	}

	public long AddressServicesImpl.countCity() {
		return count(City.class);
	}

	public long AddressServicesImpl.countCountry() {
		return count(Country.class);
	}

	public long AddressServicesImpl.countCountryState() {
		return count(CountryState.class);
	}

	private static long count(Class o) {
		return (Long) getEntityManager().createQuery(
				"select count(o) from " + o.getSimpleName() + " o")
				.getSingleResult();
	}
}
