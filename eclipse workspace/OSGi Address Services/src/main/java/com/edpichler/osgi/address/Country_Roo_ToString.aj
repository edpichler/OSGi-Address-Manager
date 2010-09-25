package com.edpichler.osgi.address;

import java.lang.String;

privileged aspect Country_Roo_ToString {
    
    public String Country.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Sign: ").append(getSign());
        return sb.toString();
    }
    
}
