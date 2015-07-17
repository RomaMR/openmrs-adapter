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
}
