package org.openmrs.service.content;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.openmrs.service.rest.RestTemplateAdapter;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by romanmudryi on 03.08.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultContentServiceTest extends TestCase {

    public static final String HOST = "http://localhost:8080/openmrs-adapter/api/contents";

    @Mock
    private RestTemplateAdapter restTemplateAdapter;

    @InjectMocks
    private DefaultContentService unit;

    @Before
    public void setup(){
        unit.setHost(HOST);
    }

    @Test
    public void testGetContent() throws Exception {
        // Given
        String uuid = "ab563ece-97be-426e-89ed-939cab6ab9f8_ab563ece-97be-426e-89ed-939cab6ab9f8_download.jpg_1438547423892.image/jpeg";
        byte[] expectedArray = new byte[0];

        ResponseEntity<byte[]> expected = new ResponseEntity<byte[]>(expectedArray, HttpStatus.OK);

        // When
        when(restTemplateAdapter.exchange(anyString(), any(HttpMethod.class), eq(byte[].class))).thenReturn(expected);
        byte[] actual = unit.getContent(uuid);

        // Then
        verify(restTemplateAdapter).exchange(HOST + "/" + uuid, HttpMethod.GET, byte[].class);
        assertEquals(expected.getBody(), actual);
    }

    @Test
    public void testDeleteContent() throws Exception {
        // Given
        String uuid = "ab563ece-97be-426e-89ed-939cab6ab9f8_ab563ece-97be-426e-89ed-939cab6ab9f8_download.jpg_1438547423892.image/jpeg";

        ResponseEntity<Void> expected = new ResponseEntity<Void>(HttpStatus.OK);

        // When
        when(restTemplateAdapter.exchange(anyString(), any(HttpMethod.class), eq(Void.class))).thenReturn(expected);
        unit.deleteContent(uuid);

        // Then
        verify(restTemplateAdapter).exchange(HOST + "/" + uuid, HttpMethod.DELETE, Void.class);
    }
}