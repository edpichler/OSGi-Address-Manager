package com.edpichler.osgi.address;

import java.lang.String;

privileged aspect Address_Roo_ToString {
    
    public String Address.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Street: ").append(getStreet()).append(", ");
        sb.append("Complement: ").append(getComplement()).append(", ");
        sb.append("PostalCode: ").append(getPostalCode()).append(", ");
        sb.append("Latitude: ").append(getLatitude()).append(", ");
        sb.append("Longitude: ").append(getLongitude()).append(", ");
        sb.append("City: ").append(getCity()).append(", ");
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion());
        return sb.toString();
    }
    
}
