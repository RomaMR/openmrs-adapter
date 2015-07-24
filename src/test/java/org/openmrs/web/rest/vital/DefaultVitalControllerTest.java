package org.openmrs.web.rest.vital;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.openmrs.domain.template.TemplateResults;
import org.openmrs.domain.vital.Vital;
import org.openmrs.service.vital.VitalService;
import org.openmrs.web.controller.BaseController;
import org.openmrs.web.controller.VitalController;
import org.openmrs.web.dto.VitalDTO;
import org.openmrs.web.rest.AbstractControllerTest;
import org.springframework.http.MediaType;

import java.util.Random;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by romanmudryi on 23.07.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultVitalControllerTest extends AbstractControllerTest {

    @Mock
    private VitalService service;

    @InjectMocks
    private VitalController unit;

    @Override
    protected BaseController getUnit() {
        return unit;
    }

    @Test
    public void testCreateVital() throws Exception{
        //Given
        Random random = new Random();
        Double value = random.nextDouble();
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

        Vital expectedVital = new Vital();

        //When
        String request = getJson(vitalDTO, true);
        String response = getJson(expectedVital, true);
        when(service.createVital(any(VitalDTO.class))).thenReturn(expectedVital);

        //Then
        mockMvc.perform(post("/api/vital")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isCreated())
                .andExpect(content().string(response));
        verify(service).createVital(vitalDTO);
    }

    @Test
    public void testUpdateVital() throws Exception{
        //Given
        Random random = new Random();
        Double value = random.nextDouble();
        String uuid = "5db1eb5d-69ff-4ed9-bdbb-dd38bcc93aed";
        String concept = "162169AAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        String person = "17406e6f-8a61-4b71-a71e-2b6f019d6eac";
        String encounter = "68dcc5d2-8cc4-46bb-a4bd-54541968918b";
        String location = "8d6c993e-c2cc-11de-8d13-0010c6dffd0f";
        VitalDTO vitalDTO = new VitalDTO();
        vitalDTO.setUuid(uuid);
        vitalDTO.setValue(value);
        vitalDTO.setConcept(concept);
        vitalDTO.setPerson(person);
        vitalDTO.setEncounter(encounter);
        vitalDTO.setLocation(location);
        vitalDTO.setObsDatetime("2014-10-09T19:02:37.613+0530");
        Vital expectedVital = new Vital();

        //When
        String request = getJson(vitalDTO, true);
        String response = getJson(expectedVital, true);
        when(service.updateVital(anyString(), any(VitalDTO.class))).thenReturn(expectedVital);

        //Then
        mockMvc.perform(put("/api/vital/{uuid}", uuid)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isCreated())
                .andExpect(content().string(response));

        verify(service).updateVital(uuid, vitalDTO);
    }

    @Test
    public void testGetVital() throws Exception{
        //Given
        String uuid = "dbd33b2a-3a0a-4cbf-a2ae-0171c671cf67";

        Vital expectedVital = new Vital();
        expectedVital.setUuid(uuid);

        //When
        String response = getJson(expectedVital, true);
        when(service.getVital(any(String.class))).thenReturn(expectedVital);

        //Then
        mockMvc.perform(get("/api/vital/{uuid}", uuid)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(response));
        verify(service).getVital(uuid);

        assertEquals(uuid, expectedVital.getUuid());
    }

    @Test
    public void testGetVitals() throws Exception{
        //Given
        String query = "ab563ece-97be-426e-89ed-939cab6ab9f8";

        TemplateResults expectedResults = new TemplateResults();

        //When
        String response = getJson(expectedResults, true);
        when(service.getVitals(any(String.class))).thenReturn(expectedResults);

        //Then
        mockMvc.perform(get("/api/vital?patient=" + query)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(response));
        verify(service).getVitals(query);
    }

    @Test
    public void testDeleteVitals() throws Exception{
        //Given
        String uuid = "ab563ece-97be-426e-89ed-939cab6ab9f8";
        Boolean purge = new Boolean(false);

        //When
        doNothing().when(service).deleteVital(uuid,purge);

        //Then
        mockMvc.perform(delete("/api/vital/" + uuid + "?purge=" + purge))
                .andExpect(status().isOk());
        verify(service).deleteVital(uuid, purge);
    }
}
