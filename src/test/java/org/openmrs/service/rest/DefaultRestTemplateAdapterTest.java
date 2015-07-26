package org.openmrs.service.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.openmrs.domain.user.User;
import org.openmrs.security.SecurityUtils;
import org.openmrs.service.security.SessionService;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by romanmudryi on 24.07.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultRestTemplateAdapterTest {

    @Mock
    private RestTemplate restTemplate;

    @Mock
    private SessionService sessionService;

    @InjectMocks
    private DefaultRestTemplateAdapter unit;

    @Test
    public void testExchange() throws Exception {
        // Given
        String url = "url";
        User user = new User("login", "password");
        String base64 = SecurityUtils.getBase64(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Basic " + base64);
        String object = "parameters";
        HttpEntity<String> entity = new HttpEntity<String>(object, headers);

        ResponseEntity<Object> expected = new ResponseEntity<Object>(object, HttpStatus.OK);

        // When
        when(sessionService.getSessionUser()).thenReturn(user);
        when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(Object.class))).thenReturn(expected);
        Object actual = unit.exchange(url, HttpMethod.GET, Object.class);

        // Then
        verify(sessionService).getSessionUser();
        verify(restTemplate).exchange(url, HttpMethod.GET, entity, Object.class);
        assertEquals(expected, actual);
    }

    @Test
    public void testExchangePOST() throws Exception {
        // Given
        String url = "url";
        User user = new User("login", "password");
        String base64 = SecurityUtils.getBase64(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Authorization", "Basic " + base64);
        String object = "parameters";
        HttpEntity<String> entity = new HttpEntity<String>(object, headers);

        ResponseEntity<Object> expected = new ResponseEntity<Object>(object, HttpStatus.OK);

        // When
        when(sessionService.getSessionUser()).thenReturn(user);
        when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(Object.class))).thenReturn(expected);
        Object actual = unit.exchangePOST(url, HttpMethod.POST, object, Object.class);

        // Then
        verify(sessionService).getSessionUser();
        verify(restTemplate).exchange(url, HttpMethod.POST, entity, Object.class);
        assertEquals(expected, actual);
    }
}
