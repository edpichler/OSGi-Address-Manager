package com.edpichler.osgi.jpa.address.conf;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Class to create EntityManagers
 * */
public class EntityManagerProvider {

	private static EntityManagerFactory fac = null;

	private EntityManagerProvider() {

	}

	/**@return A new EntytyManager instance.
	 * @see EntityManager
	 * */
	public static EntityManager createEntityManager() {
		
		if (fac == null) {
			fac = Persistence.createEntityManagerFactory("pesistenceUnit");
		}
		EntityManager ent = null;
		ent = fac.createEntityManager();
		return ent;
	}
}
