package org.acme.users;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Users {
    public Long id;
    public String name;
    public String surname;
    public String email;
    private boolean selectedUser;
    private Map<Integer, Boolean> checkboxValues = new HashMap<>();

    public Users() {
    }

    public Users(Long id, String name, String surname, String email, boolean selectedUser) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.selectedUser = selectedUser;
    }


    public Map<Integer, Boolean> getCheckboxValues() {
        return checkboxValues;
    }

    public void setCheckboxValues(Map<Integer, Boolean> checkboxValues) {
        this.checkboxValues = checkboxValues;
    }

    public boolean isSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(boolean selectedUser) {
        this.selectedUser = selectedUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
