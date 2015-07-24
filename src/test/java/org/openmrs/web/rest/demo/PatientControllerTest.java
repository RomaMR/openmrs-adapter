package org.openmrs.web.rest.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.domain.patient.Patient;
import org.openmrs.domain.template.TemplateResults;
import org.openmrs.security.SecurityUtils;
import org.openmrs.web.dto.IdentifierDTO;
import org.openmrs.web.dto.PatientDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by romanmudryi on 17.07.15.
 */
public class PatientControllerTest {

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

    @Test
    public void testCreate(){
        String person = "007037a0-0500-11e3-8ffd-0800200c9a66";
        String identifierType = "05a29f94-c0ed-11e2-94be-8c13b969e334";
        String location = "8d6c993e-c2cc-11de-8d13-0010c6dffd0f";
        PatientDTO patientDTO =  new PatientDTO();
        patientDTO.setPerson(person);
        IdentifierDTO identifierDTO = new IdentifierDTO();
        Random random = new Random();
        identifierDTO.setIdentifier(String.valueOf(random.nextInt()));
        identifierDTO.setIdentifierType(identifierType);
        identifierDTO.setLocation(location);
        identifierDTO.setPreferred(true);
        List<IdentifierDTO> identifierDTOs = new ArrayList<>();
        identifierDTOs.add(identifierDTO);
        patientDTO.setIdentifiers(identifierDTOs);
        HttpEntity<PatientDTO> entity = new HttpEntity<>(patientDTO, headers);
        ResponseEntity<Patient> result = restTemplate.exchange(URL, HttpMethod.POST, entity, Patient.class);
        Assert.assertEquals(result.getBody().getPerson().getUuid(), person);
    }

    @Test
    public void testUpdate(){
        String patient = "007037a0-0500-11e3-8ffd-0800200c9a66";
        String person = "007037a0-0500-11e3-8ffd-0800200c9a66";
        String identifierType = "05a29f94-c0ed-11e2-94be-8c13b969e334";
        String location = "8d6c993e-c2cc-11de-8d13-0010c6dffd0f";
        PatientDTO patientDTO =  new PatientDTO();
        patientDTO.setUuid(patient);
        patientDTO.setPerson(person);
        IdentifierDTO identifierDTO = new IdentifierDTO();
        Random random = new Random();
        identifierDTO.setIdentifier(String.valueOf(random.nextInt()));
        identifierDTO.setIdentifierType(identifierType);
        identifierDTO.setLocation(location);
        identifierDTO.setPreferred(true);
        List<IdentifierDTO> identifierDTOs = new ArrayList<>();
        identifierDTOs.add(identifierDTO);
        patientDTO.setIdentifiers(identifierDTOs);
        HttpEntity<PatientDTO> entity = new HttpEntity<>(patientDTO, headers);
        ResponseEntity<Patient> result = restTemplate.exchange(URL + "/" + patient, HttpMethod.PUT, entity, Patient.class);
        Assert.assertEquals(result.getBody().getPerson().getUuid(), person);
    }

}
