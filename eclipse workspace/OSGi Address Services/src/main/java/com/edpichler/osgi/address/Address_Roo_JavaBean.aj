package com.edpichler.osgi.address;

import com.edpichler.osgi.address.City;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;

privileged aspect Address_Roo_JavaBean {
    
    public String Address.getStreet() {
        return this.street;
    }
    
    public void Address.setStreet(String street) {
        this.street = street;
    }
    
    public String Address.getComplement() {
        return this.complement;
    }
    
    public void Address.setComplement(String complement) {
        this.complement = complement;
    }
    
    public String Address.getPostalCode() {
        return this.postalCode;
    }
    
    public void Address.setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public int Address.getLatitude() {
        return this.latitude;
    }
    
    public void Address.setLatitude(int latitude) {
        this.latitude = latitude;
    }
    
    public int Address.getLongitude() {
        return this.longitude;
    }
    
    public void Address.setLongitude(int longitude) {
        this.longitude = longitude;
    }
    
    public City Address.getCity() {
        return this.city;
    }
    
    public void Address.setCity(City city) {
        this.city = city;
    }
    
    public Long Address.getId() {
        return this.id;
    }
    
    public void Address.setId(Long id) {
        this.id = id;
    }
    
    public Integer Address.getVersion() {
        return this.version;
    }
    
    public void Address.setVersion(Integer version) {
        this.version = version;
    }
    
}
