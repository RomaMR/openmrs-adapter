package org.openmrs.service.content;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by romanmudryi on 02.08.15.
 */
public interface ContentService {

    byte[] getContent(String id);

    String saveContent(String patientId, String encounterId, InputStream inputStream, String fileName) throws IOException;

    void deleteContent(String uuid);
}
