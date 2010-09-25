package com.edpichler.osgi.jpa.address.conf.impl;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.edpichler.osgi.jpa.address.conf.ConfigurationServiceProvider;
import com.edpichler.osgi.jpa.address.conf.IAddressServicesConfiguration;

public class JPAUtil implements IAddressServicesConfiguration {
	private static Map properties;
	private static EntityManagerFactory emf;
	private static final String PERSISTENCE_UNIT = "pesistenceUnit";

	/**
	 * Create an EntityManager.
	 * 
	 * @see ConfigurationServiceProvider
	 */
	public static EntityManager createEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT,
					properties);
		}

		EntityManager em = emf.createEntityManager();
		return em;
	}

	@Override
	public void setAddressServiceConfiguration(Map prop) {
		if (emf != null) {
			throw new IllegalStateException(
					"The persistent context was already" + " initialized."
							+ " You only can set the properties "
							+ "before calling any service.");
		}
		properties = prop;
	}

}
