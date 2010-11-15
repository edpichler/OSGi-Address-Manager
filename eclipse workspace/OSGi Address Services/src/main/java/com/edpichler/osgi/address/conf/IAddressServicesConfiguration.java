package com.edpichler.osgi.address.conf;

import java.util.Map;

/** Set the configuration */
public interface IAddressServicesConfiguration {
	/**
	 * You can override any EclipseLink properties of the persistence.xml file.
	 * After overriding, the EntityManagerFactory will be closed and recreated.
	 * Examples:
	 * 
	 * <br/>
	 * property name="javax.persistence.jdbc.driver"
	 * value="org.apache.derby.jdbc.EmbeddedDriver" <br/>
	 * property name="javax.persistence.jdbc.user" value="admin" <br/>
	 * property name="javax.persistence.jdbc.password" value="secret" <br/>
	 * property name="javax.persistence.jdbc.url"
	 * value="jdbc:derby:address;create=true" <br/>
	 * property name="eclipselink.target-database" value="Derby"
	 * 
	 * */
	public void setAddressServiceConfiguration(Map prop) throws IllegalStateException;
}
