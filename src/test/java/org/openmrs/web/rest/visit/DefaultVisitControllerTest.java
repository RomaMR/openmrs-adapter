package org.openmrs.web.rest.visit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.openmrs.domain.template.TemplateResults;
import org.openmrs.domain.visit.Visit;
import org.openmrs.service.visit.VisitService;
import org.openmrs.web.controller.BaseController;
import org.openmrs.web.controller.VisitController;
import org.openmrs.web.dto.VisitDTO;
import org.openmrs.web.rest.AbstractControllerTest;
import org.springframework.http.MediaType;

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
public class DefaultVisitControllerTest extends AbstractControllerTest {

    @Mock
    private VisitService service;

    @InjectMocks
    private VisitController unit;

    @Override
    protected BaseController getUnit() {
        return unit;
    }

    @Test
    public void testCreateVisit() throws Exception{
        //Given
        String patient = "17406e6f-8a61-4b71-a71e-2b6f019d6eac";
        String visitType = "7b0f5697-27e3-40c4-8bae-f4049abfb4ed";
        String location = "8d6c993e-c2cc-11de-8d13-0010c6dffd0f";
        VisitDTO visitDTO = new VisitDTO();
        visitDTO.setLocation(location);
        visitDTO.setPatient(patient);
        visitDTO.setVisitType(visitType);
        visitDTO.setStartDatetime("2014-10-09T19:02:37.613+0530");

        Visit expectedVisit = new Visit();

        //When
        String request = getJson(visitDTO, true);
        String response = getJson(expectedVisit, true);
        when(service.createVisit(any(VisitDTO.class))).thenReturn(expectedVisit);

        //Then
        mockMvc.perform(post("/api/visit")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isCreated())
                .andExpect(content().string(response));
        verify(service).createVisit(visitDTO);
    }

    @Test
    public void testUpdateVisit() throws Exception{
        //Given
        String uuid = "3dd9a4e3-be93-4830-9b74-48bcd25c744b";
        String patient = "17406e6f-8a61-4b71-a71e-2b6f019d6eac";
        String visitType = "7b0f5697-27e3-40c4-8bae-f4049abfb4ed";
        String location = "8d6c993e-c2cc-11de-8d13-0010c6dffd0f";
        VisitDTO visitDTO = new VisitDTO();
        visitDTO.setUuid(uuid);
        visitDTO.setLocation(location);
        visitDTO.setPatient(patient);
        visitDTO.setVisitType(visitType);
        visitDTO.setStartDatetime("2014-10-09T19:02:37.613+0530");

        Visit expectedVisit = new Visit();

        //When
        String request = getJson(visitDTO, true);
        String response = getJson(expectedVisit, true);
        when(service.updateVisit(anyString(), any(VisitDTO.class))).thenReturn(expectedVisit);

        //Then
        mockMvc.perform(put("/api/visit/{uuid}", uuid)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andExpect(status().isCreated())
                .andExpect(content().string(response));

        verify(service).updateVisit(uuid, visitDTO);
    }

    @Test
    public void testGetVisit() throws Exception{
        //Given
        String uuid = "3dd9a4e3-be93-4830-9b74-48bcd25c744b";

        Visit expectedVisit = new Visit();
        expectedVisit.setUuid(uuid);

        //When
        String response = getJson(expectedVisit, true);
        when(service.getVisit(any(String.class))).thenReturn(expectedVisit);

        //Then
        mockMvc.perform(get("/api/visit/{uuid}", uuid)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(response));
        verify(service).getVisit(uuid);

        assertEquals(uuid, expectedVisit.getUuid());
    }

    @Test
    public void testGetVisits() throws Exception{
        //Given
        String query = "ab563ece-97be-426e-89ed-939cab6ab9f8";

        TemplateResults expectedResults = new TemplateResults();

        //When
        String response = getJson(expectedResults, true);
        when(service.getVisits(any(String.class))).thenReturn(expectedResults);

        //Then
        mockMvc.perform(get("/api/visit?patient=" + query)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(response));
        verify(service).getVisits(query);
    }
}
