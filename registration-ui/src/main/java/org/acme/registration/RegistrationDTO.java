package org.acme.registration;

import java.io.Serializable;

public class RegistrationDTO implements Serializable {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private boolean selectedUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(boolean selectedUser) {
        this.selectedUser = selectedUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
