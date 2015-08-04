package org.openmrs.service.content;

import org.apache.commons.io.IOUtils;
import org.openmrs.service.rest.RestTemplateAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by romanmudryi on 29.07.15.
 */
@Component("contentService")
public class DefaultContentService implements ContentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultContentService.class);

    private static final String PATIENT_ID = "patientId";

    private static final String ENCOUNTER_ID = "encounterId";

    @Resource(name = "restTemplateAdapter")
    private RestTemplateAdapter restTemplateAdapter;

    private String host;

    private String tempPath;

    @Value("${openmrs.host.content}")
    public void setHost(String host) {
        this.host = host;
    }

    @Value("${openmrs.temppath}")
    public void setTempPath(String tempPath) {
        this.tempPath = tempPath;
    }

    public byte[] getContent(String uuid) {
        LOGGER.info("getting content");

        ResponseEntity<byte[]> result = restTemplateAdapter.exchange(host + "/" + uuid, HttpMethod.GET, byte[].class);
        return result.getBody();
    }

    @Override
    public String saveContent(String patientId, String encounterId, InputStream inputStream, String fileName) throws IOException {
        LOGGER.info("saving content");

        ResponseEntity<String> result = null;
        String tempFileName = String.format(tempPath + "%s", fileName);

        try(FileOutputStream fo = new FileOutputStream(tempFileName)) {
            IOUtils.copy(inputStream, fo);
            LinkedMultiValueMap<String, Object> map = getParametersMap(patientId, encounterId, tempFileName);
            result = restTemplateAdapter.exchangePOST(host, HttpMethod.POST, map, String.class);
        } finally {
            File f = new File(tempFileName);
            f.delete();
        }

        return result.getBody();
    }

    private LinkedMultiValueMap<String, Object> getParametersMap(String patientId, String encounterId, String tempFileName) {
        LinkedMultiValueMap<String, Object> map = new LinkedMultiValueMap<>();

        map.add(PATIENT_ID, patientId);
        map.add(ENCOUNTER_ID, encounterId);
        map.add("file", new FileSystemResource(tempFileName));

        return map;
    }

    @Override
    public void deleteContent(String uuid) {
        LOGGER.info("deleting content");

        restTemplateAdapter.exchange(host + "/" + uuid, HttpMethod.DELETE, Void.class);
    }


}
