package com.edpichler.osgi.address;

import java.lang.Long;
import java.lang.String;

privileged aspect Country_Roo_JavaBean {
    
    public Long Country.getId() {
        return this.id;
    }
    
    public void Country.setId(Long id) {
        this.id = id;
    }
    
    public String Country.getName() {
        return this.name;
    }
    
    public void Country.setName(String name) {
        this.name = name;
    }
    
    public String Country.getSign() {
        return this.sign;
    }
    
    public void Country.setSign(String sign) {
        this.sign = sign;
    }
    
}
