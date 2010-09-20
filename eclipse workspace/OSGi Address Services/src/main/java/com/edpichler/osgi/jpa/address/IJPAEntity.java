package com.edpichler.osgi.jpa.address;

public interface IJPAEntity {
	public void persist();
	public void remove();
	public void merge();	
}
