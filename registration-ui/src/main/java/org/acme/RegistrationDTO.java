package org.acme;

import java.io.Serializable;

public class RegistrationDTO implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
