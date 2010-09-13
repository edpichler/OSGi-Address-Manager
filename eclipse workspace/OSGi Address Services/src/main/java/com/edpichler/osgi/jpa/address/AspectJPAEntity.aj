package com.edpichler.osgi.jpa.address;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.edpichler.osgi.address.conf.AddressServicesConfiguration;


privileged @SuppressWarnings("unused")
		aspect AspectJPAEntity {
	private static EntityManagerFactory emf;
	private static final String PERSISTENCE_UNIT = "pesistenceUnit";

	private static Properties propes;

	public Address Address.find(int id) {
		EntityManager em = createEntityManager();
		em.close();
		return null;

	}

	/**You can override any EclipseLink properties of the persistence.xml file. 
	 * After overriding, the EntityManagerFactory will be closed and recreated.
	 * Examples:
	 * 
			<property name="javax.persistence.jdbc.driver" value="org.apache.derby.jdbc.EmbeddedDriver" />
			<property name="javax.persistence.jdbc.username" value="admin" />
			<property name="javax.persistence.jdbc.password" value="secret" />
			<property name="javax.persistence.jdbc.url" value="jdbc:derby:address;create=true" />
			<property name="eclipselink.target-database" value="Derby" />

	 * */
	public static void AddressServicesConfiguration.setPersistenceUnitProperties(
			Properties prop) {
		propes = prop;
		emf.close();
		emf = null;
	}

	public static EntityManager createEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT,
					propes);
		}

		EntityManager em = emf.createEntityManager();
		return em;
	}
}
