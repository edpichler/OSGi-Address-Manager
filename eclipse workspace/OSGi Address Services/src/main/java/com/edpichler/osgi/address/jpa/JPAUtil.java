package com.edpichler.osgi.address.jpa;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.edpichler.osgi.address.conf.ConfigurationServiceProvider;
import com.edpichler.osgi.address.conf.IAddressServicesConfiguration;

public class JPAUtil implements IAddressServicesConfiguration {
	private static Map properties;
	private static EntityManagerFactory emf;
	private static final String PERSISTENCE_UNIT = "pesistenceUnit";

	private JPAUtil() {

	}

	/** @return the singleton */
	public static JPAUtil getInstance() {
		return new JPAUtil();
	}

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

	public void setAddressServiceConfiguration(Map prop)
			throws IllegalStateException {
		if (emf != null) {
			throw new IllegalStateException(
					"The persistent context was already been"
							+ " initialized."
							+ " You only can set the properties "
							+ "before calling any service or initializing the persist context.");
		}
		properties = prop;
	}

}
