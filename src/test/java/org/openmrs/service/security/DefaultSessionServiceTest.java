package org.openmrs.service.security;

import org.junit.Before;
import org.junit.Test;
import org.openmrs.domain.user.User;

import static org.junit.Assert.assertEquals;

/**
 * Created by romanmudryi on 24.07.15.
 */
public class DefaultSessionServiceTest {

    private DefaultSessionService unit = new DefaultSessionService();

    private String login = "login";

    private String password = "password";

    @Before
    public void setup() {
        unit.setOpenmrsUsername(login);
        unit.setOpenmrsPassword(password);
    }


    @Test
    public void testGetSessionUser() throws Exception {
        // Given
        User expected = new User(login, password);

        // When
        User actual = unit.getSessionUser();

        // Then
        assertEquals(expected, actual);
    }
}