package org.openmrs.service.content;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by romanmudryi on 02.08.15.
 */
public interface ContentService {

    byte[] getContent(String id);

    String saveContent(String patientId, String encounterId, MultipartFile file) throws IOException;

    void deleteContent(String uuid);
}
