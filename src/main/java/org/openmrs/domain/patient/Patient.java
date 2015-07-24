package org.openmrs.domain.patient;

import org.openmrs.domain.person.Person;
import org.openmrs.domain.template.Template;
import org.openmrs.domain.template.TemplateLinks;

import java.io.Serializable;
import java.util.List;

/**
 * Created by romanmudryi on 15.07.15.
 */
public class Patient implements Serializable{

    private String uuid;

    private String display;

    private List<Template> identifiers;

    private Person person;

    private Boolean voided;

    private List<TemplateLinks> links;

    private String resourceVersion;

    public Patient() {
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public List<Template> getIdentifiers() {
        return identifiers;
    }

    public void setIdentifiers(List<Template> identifiers) {
        this.identifiers = identifiers;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Boolean getVoided() {
        return voided;
    }

    public void setVoided(Boolean voided) {
        this.voided = voided;
    }

    public List<TemplateLinks> getLinks() {
        return links;
    }

    public void setLinks(List<TemplateLinks> links) {
        this.links = links;
    }

    public String getResourceVersion() {
        return resourceVersion;
    }

    public void setResourceVersion(String resourceVersion) {
        this.resourceVersion = resourceVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;

        Patient patient = (Patient) o;

        if (uuid != null ? !uuid.equals(patient.uuid) : patient.uuid != null) return false;
        if (display != null ? !display.equals(patient.display) : patient.display != null) return false;
        if (identifiers != null ? !identifiers.equals(patient.identifiers) : patient.identifiers != null) return false;
        if (person != null ? !person.equals(patient.person) : patient.person != null) return false;
        if (voided != null ? !voided.equals(patient.voided) : patient.voided != null) return false;
        if (links != null ? !links.equals(patient.links) : patient.links != null) return false;
        return !(resourceVersion != null ? !resourceVersion.equals(patient.resourceVersion) : patient.resourceVersion != null);

    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (display != null ? display.hashCode() : 0);
        result = 31 * result + (identifiers != null ? identifiers.hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (voided != null ? voided.hashCode() : 0);
        result = 31 * result + (links != null ? links.hashCode() : 0);
        result = 31 * result + (resourceVersion != null ? resourceVersion.hashCode() : 0);
        return result;
    }
}
