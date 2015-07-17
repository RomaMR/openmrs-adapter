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
}
