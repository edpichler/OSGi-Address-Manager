package com.edpichler.osgi.jpa.address;

public interface IJPAEntity {
	/**
	 * Persist the object
	 * */
	public void persist();
	/**
	 * Remove the object
	 * */
	public void remove();
	/**
	 * Merge/update the object
	 * */
	public void merge();	
}
