package org.openmrs.web.rest.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.domain.patient.Patient;
import org.openmrs.domain.template.TemplateResults;
import org.openmrs.domain.visit.Visit;
import org.openmrs.security.SecurityUtils;
import org.openmrs.web.dto.VisitDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by romanmudryi on 17.07.15.
 */
public class VisitControllerTest {

    private RestTemplate restTemplate;

    private HttpEntity<String> entity;

    private HttpHeaders headers;

    private final static String URL = "http://localhost:8080/openmrs-adapter/api/visit";

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
        String uuid = "322affaf-3403-4056-a7ce-d32724edeb94";
        ResponseEntity<Patient> result = restTemplate.exchange(URL + "/" + uuid, HttpMethod.GET, entity, Patient.class);
        Assert.assertEquals(uuid, result.getBody().getUuid());
    }

    @Test
    public void testGetAll(){
        String query = "ab563ece-97be-426e-89ed-939cab6ab9f8";
        ResponseEntity<TemplateResults> result = restTemplate.exchange(URL + "?patient=" + query, HttpMethod.GET, entity, TemplateResults.class);
        Assert.assertNotEquals(result.getBody().getResults().size(), 0);
    }

    @Test
    public void testCreate(){
        String patient = "17406e6f-8a61-4b71-a71e-2b6f019d6eac";
        String visitType = "7b0f5697-27e3-40c4-8bae-f4049abfb4ed";
        String location = "8d6c993e-c2cc-11de-8d13-0010c6dffd0f";
        VisitDTO visitDTO = new VisitDTO();
        visitDTO.setLocation(location);
        visitDTO.setPatient(patient);
        visitDTO.setVisitType(visitType);
        visitDTO.setStartDatetime("2014-10-09T19:02:37.613+0530");
        HttpEntity<VisitDTO> entity = new HttpEntity<>(visitDTO, headers);
        ResponseEntity<Visit> result = restTemplate.exchange(URL, HttpMethod.POST, entity, Visit.class);
        Assert.assertEquals(result.getBody().getPatient().getUuid(), patient);
    }

    @Test
    public void testUpdate(){
        String uuid = "322affaf-3403-4056-a7ce-d32724edeb94";
        String visitType = "7b0f5697-27e3-40c4-8bae-f4049abfb4ed";
        VisitDTO visitDTO = new VisitDTO();
        visitDTO.setUuid(uuid);
        visitDTO.setVisitType(visitType);
        visitDTO.setStartDatetime("2014-10-09T19:02:37.613+0530");
        HttpEntity<VisitDTO> entity = new HttpEntity<>(visitDTO, headers);
        ResponseEntity<Visit> result = restTemplate.exchange(URL + "/" + uuid, HttpMethod.PUT, entity, Visit.class);
        Assert.assertEquals(result.getBody().getUuid(), uuid);
    }

}
