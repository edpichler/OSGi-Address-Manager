package com.edpichler.osgi.jpa.address.imp;

import javax.persistence.EntityManager;

import com.edpichler.osgi.jpa.address.IAddress;
import com.edpichler.osgi.jpa.address.conf.EntityManagerProvider;

/**
 * Aspect that persists, retrieve, update and delete an object
 * */
privileged aspect EntityCrudAspect {

	private static final EntityManager getEntityManager()  {
		EntityManager ent = EntityManagerProvider.createEntityManager();
		return ent;
	}

	// persist
	public void Address.persist() {
		EntityManager ent = getEntityManager();
		ent.getTransaction().begin();
		ent.persist(this);
		ent.getTransaction().commit();
		ent.close();
	}

	public void City.persist() {
		EntityManager ent = getEntityManager();
		ent.getTransaction().begin();
		ent.persist(this);
		ent.getTransaction().commit();
		ent.close();
	}

	public void Country.persist() {
		EntityManager ent = getEntityManager();
		ent.getTransaction().begin();
		ent.persist(this);
		ent.getTransaction().commit();
		ent.close();
	}

	public void CountryState.persist() {
		EntityManager ent = getEntityManager();
		ent.getTransaction().begin();
		ent.persist(this);
		ent.getTransaction().commit();
		ent.close();
	}

	// remove
	public void Address.remove() {
		EntityManager ent = getEntityManager();
		ent.getTransaction().begin();
		if (ent.contains(this)) {
			ent.remove(this);
		} else {
			Address attached = ent.find(Address.class, this.id);
			ent.remove(attached);
		}
		ent.getTransaction().commit();
		ent.close();
	}

	public void Country.remove() {
		EntityManager ent = getEntityManager();
		ent.getTransaction().begin();
		if (ent.contains(this)) {
			ent.remove(this);
		} else {
			Country attached = ent.find(Country.class, this.id);
			ent.remove(attached);
		}
		ent.getTransaction().commit();
		ent.close();
	}

	public void CountryState.remove() {
		EntityManager ent = getEntityManager();
		ent.getTransaction().begin();
		if (ent.contains(this)) {
			ent.remove(this);
		} else {
			CountryState attached = ent.find(CountryState.class, this.id);
			ent.remove(attached);
		}
		ent.getTransaction().commit();
		ent.close();
	}

	public void City.remove() {
		EntityManager ent = getEntityManager();
		ent.getTransaction().begin();
		if (ent.contains(this)) {
			ent.remove(this);
		} else {
			City attached = ent.find(City.class, this.id);
			ent.remove(attached);
		}
		ent.getTransaction().commit();
		ent.close();
	}

	// merge
	public void Address.merge() {
		// JPA Entity Manager
		EntityManager ent = getEntityManager();
		ent.getTransaction().begin();
		ent.merge(this);
		ent.getTransaction().commit();
		//ent.flush();
		ent.close();
	}

	public void Country.merge() {
		// JPA Entity Manager
		EntityManager ent = getEntityManager();
		ent.getTransaction().begin();
		ent.merge(this);
		ent.getTransaction().commit();
		ent.close();
	}

	public void City.merge() {
		// JPA Entity Manager
		EntityManager ent = getEntityManager();
		ent.getTransaction().begin();
		ent.merge(this);
		ent.getTransaction().commit();
		ent.close();
	}

	public void CountryState.merge() {
		// JPA Entity Manager
		EntityManager ent = getEntityManager();
		ent.getTransaction().begin();
		ent.merge(this);
		ent.getTransaction().commit();		
		ent.close();
	}

	//FIND BY ID
	@SuppressWarnings("unchecked")
	public IAddress Address.find(long id) {
		return (IAddress) findById(Address.class, id);
	}

	@SuppressWarnings("unchecked")
	public static Country Country.find(long id) {
		return (Country) findById(Country.class, id);
	}

	@SuppressWarnings("unchecked")
	public static City City.find(long id) {
		return (City) findById(City.class, id);
	}

	@SuppressWarnings("unchecked")
	public static CountryState CountryState.find(long id) {
		return (CountryState) findById(CountryState.class, id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object findById(Class o, long id) {
		return getEntityManager().find(o, id);
	}
}
