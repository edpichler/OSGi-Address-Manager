package com.edpichler.osgi.jpa.address.conf;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.edpichler.osgi.jpa.address.conf.*;

privileged @SuppressWarnings("unused")
aspect AspectJPAEntity {
	private static EntityManagerFactory emf;
	private static final String PERSISTENCE_UNIT = "pesistenceUnit";

	private static Properties propes;

	/**
	 * You can override any EclipseLink properties of the persistence.xml file.
	 * After overriding, the EntityManagerFactory will be closed and recreated.
	 * Examples:
	 * 
	 * <br/>
	 * property name="javax.persistence.jdbc.driver"
	 * value="org.apache.derby.jdbc.EmbeddedDriver" <br/>
	 * property name="javax.persistence.jdbc.username" value="admin" <br/>
	 * property name="javax.persistence.jdbc.password" value="secret" <br/>
	 * property name="javax.persistence.jdbc.url"
	 * value="jdbc:derby:address;create=true" <br/>
	 * property name="eclipselink.target-database" value="Derby"
	 * 
	 * */
	public static void AddressServicesConfiguration.setPersistenceUnitProperties(
			Properties prop) {
		propes = prop;
		emf.close();
		emf = null;
	}

	/**
	 * Create an EntityManager.
	 * 
	 * @see AddressServicesConfiguration
	 */
	public static EntityManager EntityManagerProvider.createEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT,
					propes);
		}

		EntityManager em = emf.createEntityManager();
		return em;
	}
}
