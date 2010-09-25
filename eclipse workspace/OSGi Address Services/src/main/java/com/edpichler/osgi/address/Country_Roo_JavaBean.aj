package com.edpichler.osgi.address;

import java.lang.String;

privileged aspect Country_Roo_JavaBean {
    
    public int Country.getId() {
        return this.id;
    }
    
    public void Country.setId(int id) {
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
