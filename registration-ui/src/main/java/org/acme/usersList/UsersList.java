package org.acme.usersList;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.acme.mail.MailClient;
import org.acme.mail.MailService;
import org.acme.registration.RegistrationClient;
import org.acme.users.Users;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class UsersList {
    @Inject
    @RestClient
    transient RegistrationClient registrationClient;
    private List<Users> allUsers = new ArrayList<>();
    private MailService mailService = new MailService();
    @Inject
    @RestClient
    transient MailClient mailClient;

    public List<Users> getTableData() {
        List<Users> resultList = registrationClient.getUsers();
        allUsers.clear();
        for (Users registration : resultList) {
            Users user = new Users();
            user.setId(registration.getId());
            user.setName(registration.getName());
            user.setSurname(registration.getSurname());
            user.setEmail(registration.getEmail());
            allUsers.add(user);
        }

        return allUsers;
    }

    public void send() {
        List<Users> selectedUsers = new ArrayList<>();
        for (Users user : allUsers) {
            if (!user.isSelectedUser()) {
                selectedUsers.add(user);
                mailClient.send(user);
            }
        }


    }

    public MailService getMailService() {
        return mailService;
    }

    public void setMailService(MailService mailService) {
        this.mailService = mailService;
    }

    public RegistrationClient getRegistrationClient() {
        return registrationClient;
    }

    public void setRegistrationClient(RegistrationClient registrationClient) {
        this.registrationClient = registrationClient;
    }

    public List<Users> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<Users> allUsers) {
        this.allUsers = allUsers;
    }

}
