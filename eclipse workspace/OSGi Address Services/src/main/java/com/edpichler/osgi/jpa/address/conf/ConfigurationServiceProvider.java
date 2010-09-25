package com.edpichler.osgi.jpa.address.conf;

import com.edpichler.osgi.jpa.address.conf.impl.JPAUtil;

public class ConfigurationServiceProvider {

	public static IAddressServicesConfiguration getAddressServicesConfiguration() {
		return new JPAUtil();
	}

}
