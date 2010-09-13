package com.edpichler.osgi.jpa.address;

import java.lang.String;

privileged aspect CountryState_Roo_ToString {
    
    public String CountryState.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Sign: ").append(getSign()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("Country: ").append(getCountry());
        return sb.toString();
    }
    
}
