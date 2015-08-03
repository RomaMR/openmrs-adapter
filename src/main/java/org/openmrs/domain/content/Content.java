package org.openmrs.domain.content;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by romanmudryi on 31.07.15.
 */
public class Content implements Serializable {

    private Long id;

    private String uuid;

    private String patientId;

    private String encounterId;

    private Date dateCreated;

    private String mimeType;

    private String fileName;

    public Content() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getEncounterId() {
        return encounterId;
    }

    public void setEncounterId(String encounterId) {
        this.encounterId = encounterId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", uuid='" + uuid + '\'' +
                ", patientId='" + patientId + '\'' +
                ", encounterId='" + encounterId + '\'' +
                ", dateCreated=" + dateCreated +
                ", mimeType='" + mimeType + '\'' +
                ", fileName='" + fileName + '\'' +
                '}';
    }
}

