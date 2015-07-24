package org.openmrs.service.security;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.openmrs.domain.user.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by romanmudryi on 24.07.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultSessionServiceTest {

    @Mock
    private SecurityContext securityContext;

    @Mock
    private Authentication authentication;

    @InjectMocks
    private DefaultSessionService unit;

    @Before
    public void setup() {
        SecurityContextHolder.setContext(securityContext);
    }


    @Test
    public void testGetSessionUser() throws Exception {
        // Given
        String login = "login";
        String password = "password";
        User expected = new User(login, password);

        // When
        when(securityContext.getAuthentication()).thenReturn(authentication);
        when(authentication.getDetails()).thenReturn(expected);
        User actual = unit.getSessionUser();

        // Then
        verify(securityContext).getAuthentication();
        verify(authentication).getDetails();
        assertEquals(expected, actual);
    }
}