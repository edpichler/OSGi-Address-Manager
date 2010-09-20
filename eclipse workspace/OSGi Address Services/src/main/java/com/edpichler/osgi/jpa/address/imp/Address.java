package com.edpichler.osgi.jpa.address.imp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

import com.edpichler.osgi.jpa.address.IAddress;
import com.edpichler.osgi.jpa.address.IJPAEntity;

@RooJavaBean
@RooToString
@Entity
public class Address implements IJPAEntity, IAddress{

	private String street, complement;

	/**
	 * CEP or Postal Code
	 * */
	private String postalCode;

	private int latitude, longitude;

	private City city;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id;

	@Version	
	private Integer version ;
}
