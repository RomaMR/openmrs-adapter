package org.openmrs.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by romanmudryi on 22.07.15.
 */
public class VisitDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String uuid;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String patient;

    private String visitType;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String location;

    private String startDatetime;

    public VisitDTO() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getVisitType() {
        return visitType;
    }

    public void setVisitType(String visitType) {
        this.visitType = visitType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(String startDatetime) {
        this.startDatetime = startDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VisitDTO)) return false;

        VisitDTO visitDTO = (VisitDTO) o;

        if (uuid != null ? !uuid.equals(visitDTO.uuid) : visitDTO.uuid != null) return false;
        if (patient != null ? !patient.equals(visitDTO.patient) : visitDTO.patient != null) return false;
        if (visitType != null ? !visitType.equals(visitDTO.visitType) : visitDTO.visitType != null) return false;
        if (location != null ? !location.equals(visitDTO.location) : visitDTO.location != null) return false;
        return !(startDatetime != null ? !startDatetime.equals(visitDTO.startDatetime) : visitDTO.startDatetime != null);

    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        result = 31 * result + (visitType != null ? visitType.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (startDatetime != null ? startDatetime.hashCode() : 0);
        return result;
    }
}
