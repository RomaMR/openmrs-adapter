package org.openmrs.web.rest.content;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.openmrs.service.content.ContentService;
import org.openmrs.web.controller.BaseController;
import org.openmrs.web.controller.ContentController;
import org.openmrs.web.rest.AbstractControllerTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.multipart.MultipartFile;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by romanmudryi on 02.08.15.
 */
@RunWith(MockitoJUnitRunner.class)
public class ContentControllerTest extends AbstractControllerTest {

    @Mock
    private ContentService service;

    @InjectMocks
    private ContentController unit;

    @Override
    protected BaseController getUnit() {
        return unit;
    }

    @Test
    public void testPost() throws Exception {
        //Given
        String patientId = "ab563ece-97be-426e-89ed-939cab6ab9f8";
        String encounterId = "ab563ece-97be-426e-89ed-939cab6ab9f8";
        MockMultipartFile mockMultipartFile = new MockMultipartFile(
                "file",                //filename
                "Hallo World".getBytes()); //content

        String expectedUUID = "ab563ece-97be-426e-89ed-939cab6ab9f8_ab563ece-97be-426e-89ed-939cab6ab9f8_download.jpg_1438547423892.image/jpeg";
        //When
        when(service.saveContent(anyString(), anyString(), any(MultipartFile.class))).thenReturn(expectedUUID);

        //Then
        mockMvc.perform(MockMvcRequestBuilders.fileUpload("/api/contents")
                .file(mockMultipartFile)
                .param("patientId", patientId)
                .param("encounterId", encounterId))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedUUID));
        verify(service).saveContent(patientId, encounterId, mockMultipartFile);
    }

    @Test
    public void testGet() throws Exception {
        //Given
        String uuid = "ab563ece-97be-426e-89ed-939cab6ab9f8_ab563ece-97be-426e-89ed-939cab6ab9f8_download.jpg_1438547423892.image/jpeg";
        byte[] expected = new byte[0];

        //When
        when(service.getContent(uuid)).thenReturn(expected);

        //Then
        mockMvc.perform(get("/api/contents/" + uuid))
                .andExpect(status().isOk());
        verify(service).getContent(uuid);
    }

    @Test
    public void testDelete() throws Exception {
        //Given
        String expectedUUID = "ab563ece-97be-426e-89ed-939cab6ab9f8_ab563ece-97be-426e-89ed-939cab6ab9f8_download.jpg_1438547423892.image/jpeg";

        //When
        doNothing().when(service).deleteContent(expectedUUID);

        //Then
        mockMvc.perform(delete("/api/contents/" + expectedUUID))
                .andExpect(status().isOk());
        verify(service).deleteContent(expectedUUID);
    }

}