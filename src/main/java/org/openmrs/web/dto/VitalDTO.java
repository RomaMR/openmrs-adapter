package org.openmrs.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by romanmudryi on 22.07.15.
 */
public class VitalDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String uuid;

    private Double value;

    private String concept;

    private String person;

    private String encounter;

    private String location;

    private String obsDatetime;

    public VitalDTO() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getEncounter() {
        return encounter;
    }

    public void setEncounter(String encounter) {
        this.encounter = encounter;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getObsDatetime() {
        return obsDatetime;
    }

    public void setObsDatetime(String obsDatetime) {
        this.obsDatetime = obsDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VitalDTO)) return false;

        VitalDTO vitalDTO = (VitalDTO) o;

        if (uuid != null ? !uuid.equals(vitalDTO.uuid) : vitalDTO.uuid != null) return false;
        if (value != null ? !value.equals(vitalDTO.value) : vitalDTO.value != null) return false;
        if (concept != null ? !concept.equals(vitalDTO.concept) : vitalDTO.concept != null) return false;
        if (person != null ? !person.equals(vitalDTO.person) : vitalDTO.person != null) return false;
        if (encounter != null ? !encounter.equals(vitalDTO.encounter) : vitalDTO.encounter != null) return false;
        if (location != null ? !location.equals(vitalDTO.location) : vitalDTO.location != null) return false;
        return !(obsDatetime != null ? !obsDatetime.equals(vitalDTO.obsDatetime) : vitalDTO.obsDatetime != null);

    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (concept != null ? concept.hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (encounter != null ? encounter.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (obsDatetime != null ? obsDatetime.hashCode() : 0);
        return result;
    }
}
