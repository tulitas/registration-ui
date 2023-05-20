package org.acme.mail;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.acme.registration.RegistrationClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Named
@ApplicationScoped

public class MailService {
    @Inject
    @RestClient
    transient MailClient mailClient;
    public void send(){
        mailClient.send();
    }
}
