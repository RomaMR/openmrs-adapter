package org.openmrs.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by romanmudryi on 22.07.15.
 */
public class PatientDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String uuid;

    private String person;

    private List<IdentifierDTO> identifiers;

    public PatientDTO() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public List<IdentifierDTO> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<IdentifierDTO> identifiers) {
        this.identifiers = identifiers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientDTO)) return false;

        PatientDTO that = (PatientDTO) o;

        if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
        if (person != null ? !person.equals(that.person) : that.person != null) return false;
        return !(identifiers != null ? !identifiers.equals(that.identifiers) : that.identifiers != null);

    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (identifiers != null ? identifiers.hashCode() : 0);
        return result;
    }
}
