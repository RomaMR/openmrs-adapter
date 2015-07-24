package org.openmrs.service.patient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.openmrs.domain.patient.Patient;
import org.openmrs.domain.template.TemplateResults;
import org.openmrs.service.rest.RestTemplateService;
import org.openmrs.web.dto.IdentifierDTO;
import org.openmrs.web.dto.PatientDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by romanmudryi on 23.07.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultPatientServiceTest {

    public static final String HOST = "http://localhost:8096/openmrs-standalone/ws/rest/v1";

    public static final String URL = HOST + "/patient";

    @Mock
    private RestTemplateService restTemplateService;

    @InjectMocks
    private DefaultPatientService unit;

    @Before
    public void setup(){
        unit.setHost(HOST);
    }

    @Test
    public void testGetPatient() throws Exception {
        // Given
        String uuid = "dbd33b2a-3a0a-4cbf-a2ae-0171c671cf67";

        Patient patient = new Patient();
        patient.setUuid(uuid);

        ResponseEntity<Patient> expected = new ResponseEntity<Patient>(patient, HttpStatus.OK);

        // When
        when(restTemplateService.exchange(anyString(), any(HttpMethod.class), eq(Patient.class))).thenReturn(expected);
        Patient actual = unit.getPatient(uuid);

        // Then
        verify(restTemplateService).exchange(URL +"/" + uuid, HttpMethod.GET, Patient.class);
        assertEquals(expected.getBody(), actual);
    }

    @Test
    public void testGetPatients() throws Exception {
        // Given
        String uuid = "dbd33b2a-3a0a-4cbf-a2ae-0171c671cf67";
        TemplateResults templateResults = new TemplateResults();

        ResponseEntity<TemplateResults> expected = new ResponseEntity<TemplateResults>(templateResults, HttpStatus.OK);

        // When
        when(restTemplateService.exchange(anyString(), any(HttpMethod.class), eq(TemplateResults.class))).thenReturn(expected);
        TemplateResults actual = unit.getPatients(uuid);

        // Then
        verify(restTemplateService).exchange(URL + "?q=" + uuid, HttpMethod.GET, TemplateResults.class);
        assertEquals(expected.getBody(), actual);
    }

    @Test
    public void testCreatePatient() throws Exception {
        // Given
        Random random = new Random();
        String identifier = String.valueOf(random.nextInt());
        String person = "007037a0-0500-11e3-8ffd-0800200c9a66";
        String identifierType = "05a29f94-c0ed-11e2-94be-8c13b969e334";
        String location = "8d6c993e-c2cc-11de-8d13-0010c6dffd0f";

        PatientDTO patientDTO =  new PatientDTO();
        patientDTO.setPerson(person);
        IdentifierDTO identifierDTO = new IdentifierDTO();
        identifierDTO.setIdentifier(identifier);
        identifierDTO.setIdentifierType(identifierType);
        identifierDTO.setLocation(location);
        identifierDTO.setPreferred(true);
        List<IdentifierDTO> identifierDTOs = new ArrayList<>();
        identifierDTOs.add(identifierDTO);
        patientDTO.setIdentifiers(identifierDTOs);


        Patient patient = new Patient();

        ResponseEntity<Patient> expected = new ResponseEntity<Patient>(patient, HttpStatus.OK);

        // When
        when(restTemplateService.exchangePOST(anyString(), any(HttpMethod.class), any(PatientDTO.class), eq(Patient.class))).thenReturn(expected);
        Patient actual  = unit.createPatient(patientDTO);

        // Then
        verify(restTemplateService).exchangePOST(URL, HttpMethod.POST, patientDTO, Patient.class);
        assertEquals(expected.getBody(), actual);
    }

    @Test
    public void testUpdatePatient() throws Exception {
        // Given
        String uuid = "3dd9a4e3-be93-4830-9b74-48bcd25c744b";
        Random random = new Random();
        String identifier = String.valueOf(random.nextInt());
        String person = "007037a0-0500-11e3-8ffd-0800200c9a66";
        String identifierType = "05a29f94-c0ed-11e2-94be-8c13b969e334";
        String location = "8d6c993e-c2cc-11de-8d13-0010c6dffd0f";

        PatientDTO patientDTO =  new PatientDTO();
        patientDTO.setPerson(person);
        IdentifierDTO identifierDTO = new IdentifierDTO();
        identifierDTO.setIdentifier(identifier);
        identifierDTO.setIdentifierType(identifierType);
        identifierDTO.setLocation(location);
        identifierDTO.setPreferred(true);
        List<IdentifierDTO> identifierDTOs = new ArrayList<>();
        identifierDTOs.add(identifierDTO);
        patientDTO.setIdentifiers(identifierDTOs);


        Patient patient = new Patient();

        ResponseEntity<Patient> expected = new ResponseEntity<Patient>(patient, HttpStatus.OK);

        // When
        when(restTemplateService.exchangePOST(anyString(), any(HttpMethod.class), any(PatientDTO.class), eq(Patient.class))).thenReturn(expected);
        Patient actual  = unit.updatePatient(uuid, patientDTO);

        // Then
        verify(restTemplateService).exchangePOST(URL, HttpMethod.POST, patientDTO, Patient.class);
        assertEquals(expected.getBody(), actual);
    }
}
