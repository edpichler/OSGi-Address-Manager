package com.edpichler.osgi.jpa.address;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@Entity
public class Address {
	@Id
	private int id;
	private String street, complement;
	
	/**
	 * CEP or Postal Code
	 * */
	private String postalCode;
	
	private int latitutde, longitude;
	
	private City city;
	
	public static void main(String[] args) {
		new Address().find(1);
	}
}
