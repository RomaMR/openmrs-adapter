package org.openmrs.service.vital;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.openmrs.domain.template.TemplateResults;
import org.openmrs.domain.vital.Vital;
import org.openmrs.service.rest.RestTemplateAdapter;
import org.openmrs.web.dto.VitalDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by romanmudryi on 23.07.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultVitalServiceTest {

    public static final String HOST = "http://localhost:8096/openmrs-standalone/ws/rest/v1";

    public static final String URL = HOST + "/obs";

    @Mock
    private RestTemplateAdapter restTemplateAdapter;

    @InjectMocks
    private DefaultVitalService unit;

    @Before
    public void setup(){
        unit.setHost(HOST);
    }

    @Test
    public void testGetVital() throws Exception {
        // Given
        String uuid = "dbd33b2a-3a0a-4cbf-a2ae-0171c671cf67";

        Vital vital = new Vital();
        vital.setUuid(uuid);

        ResponseEntity<Vital> expected = new ResponseEntity<Vital>(vital, HttpStatus.OK);

        // When
        when(restTemplateAdapter.exchange(anyString(), any(HttpMethod.class), eq(Vital.class))).thenReturn(expected);
        Vital actual = unit.getVital(uuid);

        // Then
        verify(restTemplateAdapter).exchange(URL + "/" + uuid, HttpMethod.GET, Vital.class);
        assertEquals(expected.getBody(), actual);
    }

    @Test
    public void testGetVitals() throws Exception {
        // Given
        String uuid = "dbd33b2a-3a0a-4cbf-a2ae-0171c671cf67";
        TemplateResults templateResults = new TemplateResults();

        ResponseEntity<TemplateResults> expected = new ResponseEntity<TemplateResults>(templateResults, HttpStatus.OK);

        // When
        when(restTemplateAdapter.exchange(anyString(), any(HttpMethod.class), eq(TemplateResults.class))).thenReturn(expected);
        TemplateResults actual = unit.getVitals(uuid);

        // Then
        verify(restTemplateAdapter).exchange(URL + "?patient=" + uuid, HttpMethod.GET, TemplateResults.class);
        assertEquals(expected.getBody(), actual);
    }

    @Test
    public void testCreateVital() throws Exception {
        // Given
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
        Vital vital = new Vital();

        ResponseEntity<Vital> expected = new ResponseEntity<Vital>(vital, HttpStatus.OK);

        // When
        when(restTemplateAdapter.exchangePOST(anyString(), any(HttpMethod.class), any(VitalDTO.class), eq(Vital.class))).thenReturn(expected);
        Vital actual = unit.createVital(vitalDTO);

        // Then
        verify(restTemplateAdapter).exchangePOST(URL, HttpMethod.POST, vitalDTO, Vital.class);
        assertEquals(expected.getBody(), actual);
    }

    @Test
    public void testUpdateVital() throws Exception {
        // Given
        String uuid = "dbd33b2a-3a0a-4cbf-a2ae-0171c671cf67";
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
        Vital vital = new Vital();
        vital.setUuid(uuid);

        ResponseEntity<Vital> expected = new ResponseEntity<Vital>(vital, HttpStatus.OK);

        // When
        when(restTemplateAdapter.exchangePOST(anyString(), any(HttpMethod.class), any(VitalDTO.class), eq(Vital.class))).thenReturn(expected);
        Vital actual = unit.updateVital(uuid, vitalDTO);

        // Then
        verify(restTemplateAdapter).exchangePOST(URL + "/" + uuid, HttpMethod.POST, vitalDTO, Vital.class);
        assertEquals(expected.getBody(), actual);
    }
}
