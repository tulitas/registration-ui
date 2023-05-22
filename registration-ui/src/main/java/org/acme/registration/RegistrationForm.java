package org.acme.registration;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.acme.users.Users;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.hibernate.validator.constraints.Length;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class RegistrationForm implements Serializable {
    private List<Users> allUsers;

    private static final Logger LOG = LoggerFactory.getLogger(RegistrationForm.class);
    @Inject
    @RestClient
    transient RegistrationClient registrationClient;

    private Long id;

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

    @PostConstruct
    public void init() {
        allUsers = registrationClient.getUsers();
    }



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
        return "/users-list.xhtml";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Users> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<Users> allUsers) {
        this.allUsers = allUsers;
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
