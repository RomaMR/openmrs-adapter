package org.openmrs.service.security;

import org.openmrs.domain.user.User;

public class DefaultSessionService implements SessionService {

    private String openmrsUsername;

    private String openmrsPassword;

    @Override
    public User getSessionUser() {
        return new User(openmrsUsername, openmrsPassword);
    }

    public void setOpenmrsUsername(String openmrsUsername) {
        this.openmrsUsername = openmrsUsername;
    }

    public void setOpenmrsPassword(String openmrsPassword) {
        this.openmrsPassword = openmrsPassword;
    }
}
