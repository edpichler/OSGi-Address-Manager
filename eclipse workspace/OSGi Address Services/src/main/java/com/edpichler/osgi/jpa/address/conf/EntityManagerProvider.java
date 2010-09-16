package com.edpichler.osgi.jpa.address.conf;

import javax.persistence.EntityManager;

public class EntityManagerProvider {
	private static EntityManager ent = null;

	private EntityManagerProvider() {

	}

	public static EntityManager getEntityManager() {
		if(ent  == null){
			return null;
		}
		return null;
	}
}
