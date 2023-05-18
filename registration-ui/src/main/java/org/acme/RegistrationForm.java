package org.acme;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class RegistrationForm implements Serializable {
    private static final Logger LOG = LoggerFactory.getLogger(RegistrationForm.class);
    @Inject
    @RestClient
    transient RegistrationClient registrationClient;
    @Inject
    ObjectMapper mapper;
    @NotNull
    @NotBlank
    @Length(min = 5, max = 20)
    private String name;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 20)
    private String surname;

    @NotNull
    @NotBlank
    @Length(min = 5, max = 20)
    private String email;
    private boolean registered;
    private List users;

    public void register() {
        LOG.debug("registering {}", name);
        LOG.debug("registering {}", surname);
        LOG.debug("registering {}", email);

        var reg = new RegistrationDTO();
        reg.setName(name);
        reg.setSurname(surname);
        reg.setEmail(email);
        registrationClient.register(reg);
        registered = true;
    }

    public void reset() {
        LOG.debug("resetting");
        name = null;
        surname = null;
        email = null;
        registered = false;
    }
    public String navigateToUserListPage() {
        System.out.println("HELLo page");
        return "/users-list.xhtml";
    }
    public void users(){
        LOG.debug("HELLOooo");
        users = registrationClient.getAllRegistrations();

    }

    public List getUsers() {
        return users;
    }

    public void setUsers(List users) {
        this.users = users;
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

    public boolean isRegistered() {
        return registered;
    }
}
