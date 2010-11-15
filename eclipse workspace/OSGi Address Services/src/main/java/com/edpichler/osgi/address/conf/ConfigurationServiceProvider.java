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
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map createOracleConfiguration(String user, String password,
			String host, String SID) {

		Map map = new HashMap<String, String>();
		map.put("javax.persistence.jdbc.driver", "oracle.jdbc.OracleDriver");
		map.put("javax.persistence.jdbc.user", user);
		map.put("javax.persistence.jdbc.password", password);
		map.put("javax.persistence.jdbc.url", "jdbc:oracle:thin:" + host
				+ ":1521:" + SID);
		map.put("eclipselink.target-database", "Oracle");
		return map;
	}
}
