package org.openmrs.web.rest.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.domain.patient.Patient;
import org.openmrs.domain.template.TemplateResults;
import org.openmrs.domain.vital.Vital;
import org.openmrs.security.SecurityUtils;
import org.openmrs.web.dto.VitalDTO;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by romanmudryi on 17.07.15.
 */
public class VitalControllerTest {

    private RestTemplate restTemplate;

    private HttpEntity<String> entity;

    private HttpHeaders headers;

    private final static String URL = "http://localhost:8080/openmrs-adapter/api/vital";

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
        String uuid = "dbd33b2a-3a0a-4cbf-a2ae-0171c671cf67";
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
        Double value = 98.5;
        String concept = "162169AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        String person = "17406e6f-8a61-4b71-a71e-2b6f019d6eac";
        String encounter = "68dcc5d2-8cc4-46bb-a4bd-54541968918b";
        String location = "8d6c993e-c2cc-11de-8d13-0010c6dffd0f";
        VitalDTO vitalDTO = new VitalDTO();
        vitalDTO.setValue(value);
        vitalDTO.setConcept(concept);
        vitalDTO.setPerson(person);
        vitalDTO.setEncounter(encounter);
        vitalDTO.setLocation(location);
        vitalDTO.setObsDatetime("2014-10-09T19:02:37.613+0530");
        HttpEntity<VitalDTO> entity = new HttpEntity<>(vitalDTO, headers);
        ResponseEntity<Vital> result = restTemplate.exchange(URL, HttpMethod.POST, entity, Vital.class);
        Assert.assertEquals(result.getBody().getPerson().getUuid(), person);
    }

    @Test
    public void testUpdate(){
        Random random = new Random();
        Double value = random.nextDouble();
        String uuid = "5db1eb5d-69ff-4ed9-bdbb-dd38bcc93aed";
        String concept = "162169AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        String person = "17406e6f-8a61-4b71-a71e-2b6f019d6eac";
        String encounter = "68dcc5d2-8cc4-46bb-a4bd-54541968918b";
        String location = "8d6c993e-c2cc-11de-8d13-0010c6dffd0f";
        VitalDTO vitalDTO = new VitalDTO();
        vitalDTO.setValue(value);
        vitalDTO.setConcept(concept);
        vitalDTO.setPerson(person);
        vitalDTO.setEncounter(encounter);
        vitalDTO.setLocation(location);
        vitalDTO.setObsDatetime("2014-10-09T19:02:37.613+0530");
        HttpEntity<VitalDTO> entity = new HttpEntity<>(vitalDTO, headers);
        ResponseEntity<Vital> result = restTemplate.exchange(URL + "/" + uuid, HttpMethod.PUT, entity, Vital.class);
        Assert.assertEquals(result.getBody().getValue(), String.valueOf(value));
    }

    public void testDeleteVitals() throws Exception{
        String uuid = "c7e089e3-4925-4320-ae73-b4931fba35ef";
        Boolean purge = new Boolean(false);

        ResponseEntity<Void> result = restTemplate.exchange(URL + "/" + uuid + "?purge=" + purge, HttpMethod.DELETE, entity, Void.class);
        Assert.assertEquals(result.getStatusCode(), HttpStatus.OK);
    }

}
