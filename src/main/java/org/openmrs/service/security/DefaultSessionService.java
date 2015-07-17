package org.openmrs.service.security;

import org.openmrs.domain.user.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component("sessionService")
public class DefaultSessionService implements SessionService {

    @Override
    public User getSessionUser() {
        Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
        Assert.isInstanceOf(User.class, details);

        return (User) details;
    }
}
