package com.edpichler.osgi.address.conf;

import java.util.HashMap;
import java.util.Map;

import com.edpichler.osgi.address.jpa.JPAUtil;

/** Class to configure the services */
public class ConfigurationServiceProvider {

	/** @return the configurator */
	public static IAddressServicesConfiguration getAddressServicesConfiguration() {
		return JPAUtil.getInstance();
	}

	/**
	 * @return a {@link Map} formated for Oracle databases
	 */
	@SuppressWarnings("unchecked")
	public static Map createOracleConfiguration(String user, String password,
			String host, String SID, int port) {

		String jdbcUrl = "jdbc:oracle:thin:@" + host + ":" + port + ":" + SID;
		return createConfiguration(user, password, jdbcUrl,
				"oracle.jdbc.OracleDriver", "Oracle");
	}

	/**
	 * @return a {@link Map} formated for Oracle databases
	 */
	@SuppressWarnings("unchecked")
	public static Map createDerbyConfiguration(String user, String password,
			String dataBaseName) {

		String jdbcUrl = "jdbc:derby:" + dataBaseName + ";create=true";

		return createConfiguration(user, password, jdbcUrl,
				"org.apache.derby.jdbc.EmbeddedDriver", "Derby");
	}

	@SuppressWarnings( { "unchecked" })
	private static Map createConfiguration(String user, String password,
			String jdbcUrl, String jdbcDriver, String targetDatabase) {

		Map map = new HashMap<String, String>();
		map.put("javax.persistence.jdbc.driver", jdbcDriver);
		map.put("javax.persistence.jdbc.user", user);
		map.put("javax.persistence.jdbc.password", password);
		map.put("javax.persistence.jdbc.url", jdbcUrl);
		map.put("eclipselink.target-database", targetDatabase);
		return map;
	}

}
