package com.edpichler.osgi.address.conf;

import com.edpichler.osgi.address.jpa.JPAUtil;

/** Class to configure the services */
public class ConfigurationServiceProvider {
	
	/** @return the configurator */
	public static IAddressServicesConfiguration getAddressServicesConfiguration() {
		return JPAUtil.getInstance();
	}

}
