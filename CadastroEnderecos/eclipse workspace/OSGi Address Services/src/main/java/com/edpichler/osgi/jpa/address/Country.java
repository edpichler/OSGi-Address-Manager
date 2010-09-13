package com.edpichler.osgi.jpa.address;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@Entity
public class Country {
	@Id
	private int id;
	private String name;
	private String sign;
}
