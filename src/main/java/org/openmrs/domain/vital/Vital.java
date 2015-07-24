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

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof Vital)) return false;

        Vital vital = (Vital) o;

        if (uuid != null ? !uuid.equals(vital.uuid) : vital.uuid != null) return false;
        if (display != null ? !display.equals(vital.display) : vital.display != null) return false;
        if (concept != null ? !concept.equals(vital.concept) : vital.concept != null) return false;
        if (person != null ? !person.equals(vital.person) : vital.person != null) return false;
        if (obsDatetime != null ? !obsDatetime.equals(vital.obsDatetime) : vital.obsDatetime != null) return false;
        if (accessionNumber != null ? !accessionNumber.equals(vital.accessionNumber) : vital.accessionNumber != null) return false;
        if (obsGroup != null ? !obsGroup.equals(vital.obsGroup) : vital.obsGroup != null) return false;
        if (valueCodedName != null ? !valueCodedName.equals(vital.valueCodedName) : vital.valueCodedName != null) return false;
        if (groupMembers != null ? !groupMembers.equals(vital.groupMembers) : vital.groupMembers != null) return false;
        if (comment != null ? !comment.equals(vital.comment) : vital.comment != null) return false;
        if (location != null ? !location.equals(vital.location) : vital.location != null) return false;
        if (order != null ? !order.equals(vital.order) : vital.order != null) return false;
        if (encounter != null ? !encounter.equals(vital.encounter) : vital.encounter != null) return false;
        if (voided != null ? !voided.equals(vital.voided) : vital.voided != null) return false;
        if (value != null ? !value.equals(vital.value) : vital.value != null) return false;
        if (valueModifier != null ? !valueModifier.equals(vital.valueModifier) : vital.valueModifier != null) return false;
        if (formFieldPath != null ? !formFieldPath.equals(vital.formFieldPath) : vital.formFieldPath != null) return false;
        if (formFieldNamespace != null ? !formFieldNamespace.equals(vital.formFieldNamespace) : vital.formFieldNamespace != null) return false;
        if (links != null ? !links.equals(vital.links) : vital.links != null) return false;
        return !(resourceVersion != null ? !resourceVersion.equals(vital.resourceVersion) : vital.resourceVersion != null);

    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (display != null ? display.hashCode() : 0);
        result = 31 * result + (concept != null ? concept.hashCode() : 0);
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (obsDatetime != null ? obsDatetime.hashCode() : 0);
        result = 31 * result + (accessionNumber != null ? accessionNumber.hashCode() : 0);
        result = 31 * result + (obsGroup != null ? obsGroup.hashCode() : 0);
        result = 31 * result + (valueCodedName != null ? valueCodedName.hashCode() : 0);
        result = 31 * result + (groupMembers != null ? groupMembers.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (encounter != null ? encounter.hashCode() : 0);
        result = 31 * result + (voided != null ? voided.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (valueModifier != null ? valueModifier.hashCode() : 0);
        result = 31 * result + (formFieldPath != null ? formFieldPath.hashCode() : 0);
        result = 31 * result + (formFieldNamespace != null ? formFieldNamespace.hashCode() : 0);
        result = 31 * result + (links != null ? links.hashCode() : 0);
        result = 31 * result + (resourceVersion != null ? resourceVersion.hashCode() : 0);
        return result;
    }
}
