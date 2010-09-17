package com.edpichler.osgi.jpa.address.imp;

import javax.persistence.EntityManager;

import com.edpichler.osgi.jpa.address.conf.EntityManagerProvider;

/**
 * Aspect that persists, retrieve, update and delete an object
 * */
privileged aspect EntityCrudAspect {

	private static final EntityManager getEntityManager() {
		EntityManager ent = EntityManagerProvider.createEntityManager();
		return ent;
	}

	// persist
	public void Address.persistEntity() {
		getEntityManager().persist(this);
	}
	
	public void Address.persist() {
		getEntityManager().persist(this);
	}

	public void City.persist() {
		getEntityManager().persist(this);
	}

	public void Country.persist() {
		getEntityManager().persist(this);
	}

	public void CountryState.persist() {
		getEntityManager().persist(this);
	}

	// remove
	public void Address.remove() {
		EntityManager ent = getEntityManager();
		if (ent.contains(this)) {
			ent.remove(this);
		} else {
			Address attached = ent.find(Address.class, this.id);
			ent.remove(attached);
		}
	}

	public void Country.remove() {
		EntityManager ent = getEntityManager();
		if (ent.contains(this)) {
			ent.remove(this);
		} else {
			Country attached = ent.find(Country.class, this.id);
			ent.remove(attached);
		}
	}

	public void CountryState.remove() {
		EntityManager ent = getEntityManager();
		if (ent.contains(this)) {
			ent.remove(this);
		} else {
			CountryState attached = ent.find(CountryState.class, this.id);
			ent.remove(attached);
		}
	}

	public void City.remove() {
		EntityManager ent = getEntityManager();
		if (ent.contains(this)) {
			ent.remove(this);
		} else {
			City attached = ent.find(City.class, this.id);
			ent.remove(attached);
		}
	}

	// flush
	public void Address.flush() {
		getEntityManager().flush();
	}

	public void Country.flush() {
		getEntityManager().flush();
	}

	public void CountryState.flush() {
		getEntityManager().flush();
	}

	public void City.flush() {
		getEntityManager().flush();
	}

	// merge
	public void Address.merge() {
		// JPA Entity Manager
		EntityManager ent = getEntityManager();
		ent.merge(this);
		ent.flush();
	}

	public void Country.merge() {
		// JPA Entity Manager
		EntityManager ent = getEntityManager();
		ent.merge(this);
		ent.flush();
	}

	public void City.merge() {
		// JPA Entity Manager
		EntityManager ent = getEntityManager();
		ent.merge(this);
		ent.flush();
	}

	public void CountryState.merge() {
		// JPA Entity Manager
		EntityManager ent = getEntityManager();
		ent.merge(this);
		ent.flush();
	}
	
	
}
