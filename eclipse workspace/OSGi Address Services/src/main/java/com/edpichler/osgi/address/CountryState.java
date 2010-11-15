package com.edpichler.osgi.address;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@Entity
@RooJavaBean
@RooToString
public class CountryState {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String sign;
	private String name;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Country country;
}
