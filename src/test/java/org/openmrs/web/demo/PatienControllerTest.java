package org.openmrs.web.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.domain.patient.Patient;
import org.openmrs.domain.template.TemplateResults;
import org.openmrs.security.SecurityUtils;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by romanmudryi on 17.07.15.
 */
public class PatienControllerTest {

    private RestTemplate restTemplate;

    private HttpEntity<String> entity;

    private HttpHeaders headers;

    private final static String URL = "http://localhost:8080/openmrs-adapter/api/patient";

    private final static String LOGIN = "admin";

    private final static String PASSWORD = "Admin123";

    @Before
    public void init(){
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String base64 = SecurityUtils.getBase64(LOGIN, PASSWORD);
        headers.set("Authorization", "Basic " + base64);
        entity = new HttpEntity<String>("parameters", headers);
    }


    @Test
    public void testGet(){
        String uuid = "ab563ece-97be-426e-89ed-939cab6ab9f8";
        ResponseEntity<Patient> result = restTemplate.exchange(URL + "/" + uuid, HttpMethod.GET, entity, Patient.class);
        Assert.assertEquals(uuid, result.getBody().getUuid());
    }

    @Test
    public void testGetAll(){
        String query = "John";
        ResponseEntity<TemplateResults> result = restTemplate.exchange(URL + "?query=" + query, HttpMethod.GET, entity, TemplateResults.class);
        Assert.assertNotEquals(result.getBody().getResults().size(), 0);
    }

}
