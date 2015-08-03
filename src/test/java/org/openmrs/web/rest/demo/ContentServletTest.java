package org.openmrs.web.rest.demo;

import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.security.SecurityUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by romanmudryi on 31.07.15.
 */

public class ContentServletTest {

    private RestTemplate restTemplate;

    private HttpHeaders headers;

    private final static String URL = "http://localhost:8096/openmrs-standalone/moduleServlet/openmrs-content-omod/contents/";

    private final static String LOGIN = "admin";

    private final static String PASSWORD = "Admin123";

    private final static String filePath  = "/home/romanmudryi/content/folder/123.jpg";

    @Before
    public void init(){
        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        String base64 = SecurityUtils.getBase64(LOGIN, PASSWORD);
        headers.set("Authorization", "Basic " + base64);
    }

    @Test
    public void testSave() throws IOException {
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        map.add("file", new FileSystemResource(filePath));
        map.add("patientId", "ab563ece-97be-426e-89ed-939cab6ab9f8");
        map.add("encounterId", "ab563ece-97be-426e-89ed-939cab6ab9f8");

        HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<LinkedMultiValueMap<String, Object>>(
                map, headers);
        ResponseEntity<String> result = restTemplate.exchange(URL, HttpMethod.POST, requestEntity,
                String.class);
    }

    @Test
    public void testGet() throws IOException {
        String uuid = "ab563ece-97be-426e-89ed-939cab6ab9f8_ab563ece-97be-426e-89ed-939cab6ab9f8_download.jpg_1438535961269.image/jpeg";
        HttpEntity<String> requestEntity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<byte[]> result = restTemplate.exchange(URL + uuid, HttpMethod.GET, requestEntity, byte[].class);
        File file = new File(filePath);
        FileOutputStream output = new FileOutputStream(file);
        IOUtils.write(result.getBody(), output);
    }
}
