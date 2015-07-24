package org.openmrs.web.rest.patient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.openmrs.domain.patient.Patient;
import org.openmrs.domain.template.TemplateResults;
import org.openmrs.service.patient.PatientService;
import org.openmrs.web.controller.BaseController;
import org.openmrs.web.controller.PatientController;
import org.openmrs.web.dto.IdentifierDTO;
import org.openmrs.web.dto.PatientDTO;
import org.openmrs.web.rest.AbstractControllerTest;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by romanmudryi on 23.07.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultPatientControllerTest extends AbstractControllerTest {

    @Mock
    private PatientService service;

    @InjectMocks
    private PatientController unit;

    @Override
    protected BaseController getUnit() {
        return unit;
    }

    @Test
    public void testCreatePatient() throws Exception{
        //Given
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
        Patient expectedPatient = new Patient();

        //When
        String request = getJson(patientDTO, true);
        String response = getJson(expectedPatient, true);
        when(service.createPatient(any(PatientDTO.class))).thenReturn(expectedPatient);

        //Then
        mockMvc.perform(post("/api/patient")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isCreated())
                .andExpect(content().string(response));
        verify(service).createPatient(patientDTO);
    }

    @Test
    public void testUpdatePatient() throws Exception{
        //Given
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
        Patient expectedPatient = new Patient();

        //When
        String request = getJson(patientDTO, true);
        String response = getJson(expectedPatient, true);
        when(service.updatePatient(anyString(), any(PatientDTO.class))).thenReturn(expectedPatient);

        //Then
        mockMvc.perform(put("/api/patient/{uuid}", person)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isCreated())
                .andExpect(content().string(response));

        verify(service).updatePatient(person, patientDTO);
    }

    @Test
    public void testGetPatient() throws Exception{
        //Given
        String uuid = "ab563ece-97be-426e-89ed-939cab6ab9f8";

        Patient expectedPatient = new Patient();
        expectedPatient.setUuid(uuid);

        //When
        String response = getJson(expectedPatient, true);
        when(service.getPatient(any(String.class))).thenReturn(expectedPatient);

        //Then
        mockMvc.perform(get("/api/patient/{uuid}", uuid)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(response));
        verify(service).getPatient(uuid);

        assertEquals(uuid, expectedPatient.getUuid());
    }

    @Test
    public void testGetPatients() throws Exception{
        //Given
        String query = "John";

        TemplateResults expectedResults = new TemplateResults();

        //When
        String response = getJson(expectedResults, true);
        when(service.getPatients(any(String.class))).thenReturn(expectedResults);

        //Then
        mockMvc.perform(get("/api/patient?query=" + query)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(response));
        verify(service).getPatients(query);
    }
}
