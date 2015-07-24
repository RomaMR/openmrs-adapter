package org.openmrs.service.visit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.openmrs.domain.template.TemplateResults;
import org.openmrs.domain.visit.Visit;
import org.openmrs.service.rest.RestTemplateService;
import org.openmrs.web.dto.VisitDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by romanmudryi on 23.07.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultVisitServiceTest {

    public static final String HOST = "http://localhost:8096/openmrs-standalone/ws/rest/v1";

    public static final String URL = HOST + "/visit";

    @Mock
    private RestTemplateService restTemplateService;

    @InjectMocks
    private DefaultVisitService unit;

    @Before
    public void setup(){
        unit.setHost(HOST);
    }

    @Test
    public void testGetVisit() throws Exception {
        // Given
        String uuid = "dbd33b2a-3a0a-4cbf-a2ae-0171c671cf67";

        Visit visit = new Visit();
        visit.setUuid(uuid);

        ResponseEntity<Visit> expected = new ResponseEntity<Visit>(visit, HttpStatus.OK);

        // When
        when(restTemplateService.exchange(anyString(), any(HttpMethod.class), eq(Visit.class))).thenReturn(expected);
        Visit actual = unit.getVisit(uuid);

        // Then
        verify(restTemplateService).exchange(URL +"/" + uuid, HttpMethod.GET, Visit.class);
        assertEquals(expected.getBody(), actual);
    }

    @Test
    public void testGetVisits() throws Exception {
        // Given
        String uuid = "dbd33b2a-3a0a-4cbf-a2ae-0171c671cf67";
        TemplateResults templateResults = new TemplateResults();

        ResponseEntity<TemplateResults> expected = new ResponseEntity<TemplateResults>(templateResults, HttpStatus.OK);

        // When
        when(restTemplateService.exchange(anyString(), any(HttpMethod.class), eq(TemplateResults.class))).thenReturn(expected);
        TemplateResults actual = unit.getVisits(uuid);

        // Then
        verify(restTemplateService).exchange(URL + "?patient=" + uuid, HttpMethod.GET, TemplateResults.class);
        assertEquals(expected.getBody(), actual);
    }

    @Test
    public void testCreateVisit() throws Exception {
        // Given
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

        Visit visit = new Visit();

        ResponseEntity<Visit> expected = new ResponseEntity<Visit>(visit, HttpStatus.OK);

        // When
        when(restTemplateService.exchangePOST(anyString(), any(HttpMethod.class), any(VisitDTO.class), eq(Visit.class))).thenReturn(expected);
        Visit actual = unit.createVisit(visitDTO);

        // Then
        verify(restTemplateService).exchangePOST(URL, HttpMethod.POST, visitDTO, Visit.class);
        assertEquals(expected.getBody(), actual);
    }

    @Test
    public void testUpdateVisit() throws Exception {
        // Given
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

        Visit visit = new Visit();
        visit.setUuid(uuid);

        ResponseEntity<Visit> expected = new ResponseEntity<Visit>(visit, HttpStatus.OK);

        // When
        when(restTemplateService.exchangePOST(anyString(), any(HttpMethod.class), any(VisitDTO.class), eq(Visit.class))).thenReturn(expected);
        Visit actual = unit.updateVisit(uuid, visitDTO);

        // Then
        verify(restTemplateService).exchangePOST(URL + "/" + uuid, HttpMethod.POST, visitDTO, Visit.class);
        assertEquals(expected.getBody(), actual);
    }
}
