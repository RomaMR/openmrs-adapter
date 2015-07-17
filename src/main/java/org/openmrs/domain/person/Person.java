package org.openmrs.domain.person;

import org.openmrs.domain.template.Template;
import org.openmrs.domain.template.TemplateLinks;

import java.util.Date;
import java.util.List;

/**
 * Created by romanmudryi on 15.07.15.
 */
public class Person  implements java.io.Serializable {

    private String uuid;

    private String display;

    private String gender;

    private Integer age;

    private Date birthdate;

    private Boolean birthdateEstimated;

    private Boolean dead;

    private Date deathDate;

    private Template causeOfDeath;

    private Template preferredName;

    private Template preferredAddress;

    private List<Template> attributes;

    private Boolean voided;

    private Boolean deathdateEstimated;

    private List<TemplateLinks> links;

    private String resourceVersion;

    public Person() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Boolean getBirthdateEstimated() {
        return birthdateEstimated;
    }

    public void setBirthdateEstimated(Boolean birthdateEstimated) {
        this.birthdateEstimated = birthdateEstimated;
    }

    public Boolean getDead() {
        return dead;
    }

    public void setDead(Boolean dead) {
        this.dead = dead;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public Template getCauseOfDeath() {
        return causeOfDeath;
    }

    public void setCauseOfDeath(Template causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }

    public Template getPreferredName() {
        return preferredName;
    }

    public void setPreferredName(Template preferredName) {
        this.preferredName = preferredName;
    }

    public Template getPreferredAddress() {
        return preferredAddress;
    }

    public void setPreferredAddress(Template preferredAddress) {
        this.preferredAddress = preferredAddress;
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

    public Boolean getDeathdateEstimated() {
        return deathdateEstimated;
    }

    public void setDeathdateEstimated(Boolean deathdateEstimated) {
        this.deathdateEstimated = deathdateEstimated;
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
