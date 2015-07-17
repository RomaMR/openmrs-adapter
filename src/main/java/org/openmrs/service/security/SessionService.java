package org.openmrs.service.security;

import org.openmrs.domain.user.User;

public interface SessionService {

    User getSessionUser();

}
