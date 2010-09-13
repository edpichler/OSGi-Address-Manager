package com.edpichler.osgi.jpa.address;

import com.edpichler.osgi.jpa.address.Country;
import java.lang.String;

privileged aspect CountryState_Roo_JavaBean {
    
    public int CountryState.getId() {
        return this.id;
    }
    
    public void CountryState.setId(int id) {
        this.id = id;
    }
    
    public String CountryState.getSign() {
        return this.sign;
    }
    
    public void CountryState.setSign(String sign) {
        this.sign = sign;
    }
    
    public String CountryState.getName() {
        return this.name;
    }
    
    public void CountryState.setName(String name) {
        this.name = name;
    }
    
    public Country CountryState.getCountry() {
        return this.country;
    }
    
    public void CountryState.setCountry(Country country) {
        this.country = country;
    }
    
}
