package com.edpichler.osgi.address;

import com.edpichler.osgi.address.jpa.AddressServicesImpl;

public class AddressServiceFactory {
	public static IAddressService createAddressService(){
		return new AddressServicesImpl();
	}
}
