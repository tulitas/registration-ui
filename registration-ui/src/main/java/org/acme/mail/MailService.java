package org.acme.mail;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.annotation.ManagedProperty;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import org.acme.registration.RegistrationForm;
import org.acme.users.Users;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped

public class MailService {
    @ManagedProperty("#{usersList}")
    private RegistrationForm registrationForm;
    @Inject
    @RestClient
    transient MailClient mailClient;
    public void send(Users user){


        mailClient.send(user);
    }
}
