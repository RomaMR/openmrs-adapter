package org.openmrs.domain.vital;

import org.openmrs.domain.template.Template;
import org.openmrs.domain.template.TemplateLinks;

import java.util.Date;
import java.util.List;

/**
 * Created by romanmudryi on 16.07.15.
 */
public class Vital {

    private String uuid;

    private String display;

    private Template concept;

    private Template person;

    private Date obsDatetime;

    private String accessionNumber;

    private Template obsGroup;

    private Template valueCodedName;

    private List<Template> groupMembers;

    private String comment;

    private Template location;

    private Template order;

    private Template encounter;

    private Boolean voided;

    private String value;

    private String valueModifier;

    private String formFieldPath;

    private String formFieldNamespace;

    private List<TemplateLinks> links;

    private String resourceVersion;

    public Vital() {
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

    public Template getConcept() {
        return concept;
    }

    public void setConcept(Template concept) {
        this.concept = concept;
    }

    public Template getPerson() {
        return person;
    }

    public void setPerson(Template person) {
        this.person = person;
    }

    public Date getObsDatetime() {
        return obsDatetime;
    }

    public void setObsDatetime(Date obsDatetime) {
        this.obsDatetime = obsDatetime;
    }

    public String getAccessionNumber() {
        return accessionNumber;
    }

    public void setAccessionNumber(String accessionNumber) {
        this.accessionNumber = accessionNumber;
    }

    public Template getObsGroup() {
        return obsGroup;
    }

    public void setObsGroup(Template obsGroup) {
        this.obsGroup = obsGroup;
    }

    public Template getValueCodedName() {
        return valueCodedName;
    }

    public void setValueCodedName(Template valueCodedName) {
        this.valueCodedName = valueCodedName;
    }

    public List<Template> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(List<Template> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Template getLocation() {
        return location;
    }

    public void setLocation(Template location) {
        this.location = location;
    }

    public Template getOrder() {
        return order;
    }

    public void setOrder(Template order) {
        this.order = order;
    }

    public Template getEncounter() {
        return encounter;
    }

    public void setEncounter(Template encounter) {
        this.encounter = encounter;
    }

    public Boolean getVoided() {
        return voided;
    }

    public void setVoided(Boolean voided) {
        this.voided = voided;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueModifier() {
        return valueModifier;
    }

    public void setValueModifier(String valueModifier) {
        this.valueModifier = valueModifier;
    }

    public String getFormFieldPath() {
        return formFieldPath;
    }

    public void setFormFieldPath(String formFieldPath) {
        this.formFieldPath = formFieldPath;
    }

    public String getFormFieldNamespace() {
        return formFieldNamespace;
    }

    public void setFormFieldNamespace(String formFieldNamespace) {
        this.formFieldNamespace = formFieldNamespace;
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
