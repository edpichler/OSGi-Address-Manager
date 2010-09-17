package com.edpichler.osgi.jpa.address.imp;

import com.edpichler.osgi.jpa.address.imp.CountryState;
import java.lang.String;

privileged aspect City_Roo_JavaBean {
    
    public int City.getId() {
        return this.id;
    }
    
    public void City.setId(int id) {
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
