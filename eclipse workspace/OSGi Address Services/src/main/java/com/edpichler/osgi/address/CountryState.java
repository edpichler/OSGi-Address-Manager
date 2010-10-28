package com.edpichler.osgi.address;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooJavaBean
@RooToString
public class CountryState {
	@Id
	private int id;
	private String sign;
	private String name;
	private Country country;
}
