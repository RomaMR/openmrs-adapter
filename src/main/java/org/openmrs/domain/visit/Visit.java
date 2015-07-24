package org.openmrs.domain.visit;

import org.openmrs.domain.template.Template;
import org.openmrs.domain.template.TemplateLinks;

import java.util.Date;
import java.util.List;

/**
 * Created by romanmudryi on 16.07.15.
 */
public class Visit {

    private String uuid;

    private String display;

    private Template patient;

    private Template visitType;

    private Template indication;

    private Template location;

    private Date startDatetime;

    private Date stopDatetime;

    private List<Template> encounters;

    private List<Template> attributes;

    private Boolean voided;

    private List<TemplateLinks> links;

    private String resourceVersion;

    public Visit() {
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

    public Template getPatient() {
        return patient;
    }

    public void setPatient(Template patient) {
        this.patient = patient;
    }

    public Template getVisitType() {
        return visitType;
    }

    public void setVisitType(Template visitType) {
        this.visitType = visitType;
    }

    public Template getIndication() {
        return indication;
    }

    public void setIndication(Template indication) {
        this.indication = indication;
    }

    public Template getLocation() {
        return location;
    }

    public void setLocation(Template location) {
        this.location = location;
    }

    public Date getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(Date startDatetime) {
        this.startDatetime = startDatetime;
    }

    public Date getStopDatetime() {
        return stopDatetime;
    }

    public void setStopDatetime(Date stopDatetime) {
        this.stopDatetime = stopDatetime;
    }

    public List<Template> getEncounters() {
        return encounters;
    }

    public void setEncounters(List<Template> encounters) {
        this.encounters = encounters;
    }

    public List<Template> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Template> attributes) {
        this.attributes = attributes;
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
        if (!(o instanceof Visit)) return false;

        Visit visit = (Visit) o;

        if (uuid != null ? !uuid.equals(visit.uuid) : visit.uuid != null) return false;
        if (display != null ? !display.equals(visit.display) : visit.display != null) return false;
        if (patient != null ? !patient.equals(visit.patient) : visit.patient != null) return false;
        if (visitType != null ? !visitType.equals(visit.visitType) : visit.visitType != null) return false;
        if (indication != null ? !indication.equals(visit.indication) : visit.indication != null) return false;
        if (location != null ? !location.equals(visit.location) : visit.location != null) return false;
        if (startDatetime != null ? !startDatetime.equals(visit.startDatetime) : visit.startDatetime != null) return false;
        if (stopDatetime != null ? !stopDatetime.equals(visit.stopDatetime) : visit.stopDatetime != null) return false;
        if (encounters != null ? !encounters.equals(visit.encounters) : visit.encounters != null) return false;
        if (attributes != null ? !attributes.equals(visit.attributes) : visit.attributes != null) return false;
        if (voided != null ? !voided.equals(visit.voided) : visit.voided != null) return false;
        if (links != null ? !links.equals(visit.links) : visit.links != null) return false;
        return !(resourceVersion != null ? !resourceVersion.equals(visit.resourceVersion) : visit.resourceVersion != null);

    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (display != null ? display.hashCode() : 0);
        result = 31 * result + (patient != null ? patient.hashCode() : 0);
        result = 31 * result + (visitType != null ? visitType.hashCode() : 0);
        result = 31 * result + (indication != null ? indication.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (startDatetime != null ? startDatetime.hashCode() : 0);
        result = 31 * result + (stopDatetime != null ? stopDatetime.hashCode() : 0);
        result = 31 * result + (encounters != null ? encounters.hashCode() : 0);
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        result = 31 * result + (voided != null ? voided.hashCode() : 0);
        result = 31 * result + (links != null ? links.hashCode() : 0);
        result = 31 * result + (resourceVersion != null ? resourceVersion.hashCode() : 0);
        return result;
    }
}
