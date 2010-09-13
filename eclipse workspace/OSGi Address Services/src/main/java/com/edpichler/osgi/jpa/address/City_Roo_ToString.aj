package com.edpichler.osgi.jpa.address;

import java.lang.String;

privileged aspect City_Roo_ToString {
    
    public String City.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Name: ").append(getName()).append(", ");
        sb.append("State: ").append(getState());
        return sb.toString();
    }
    
}
