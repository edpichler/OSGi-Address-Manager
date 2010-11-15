package com.edpichler.osgi.address;

import com.edpichler.osgi.address.CountryState;
import java.lang.Long;
import java.lang.String;

privileged aspect City_Roo_JavaBean {
    
    public Long City.getId() {
        return this.id;
    }
    
    public void City.setId(Long id) {
        this.id = id;
    }
    
    public String City.getName() {
        return this.name;
    }
    
    public void City.setName(String name) {
        this.name = name;
    }
    
    public CountryState City.getState() {
        return this.state;
    }
    
    public void City.setState(CountryState state) {
        this.state = state;
    }
    
}
