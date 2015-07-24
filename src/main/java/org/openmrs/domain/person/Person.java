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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (uuid != null ? !uuid.equals(person.uuid) : person.uuid != null) return false;
        if (display != null ? !display.equals(person.display) : person.display != null) return false;
        if (gender != null ? !gender.equals(person.gender) : person.gender != null) return false;
        if (age != null ? !age.equals(person.age) : person.age != null) return false;
        if (birthdate != null ? !birthdate.equals(person.birthdate) : person.birthdate != null) return false;
        if (birthdateEstimated != null ? !birthdateEstimated.equals(person.birthdateEstimated) : person.birthdateEstimated != null) return false;
        if (dead != null ? !dead.equals(person.dead) : person.dead != null) return false;
        if (deathDate != null ? !deathDate.equals(person.deathDate) : person.deathDate != null) return false;
        if (causeOfDeath != null ? !causeOfDeath.equals(person.causeOfDeath) : person.causeOfDeath != null) return false;
        if (preferredName != null ? !preferredName.equals(person.preferredName) : person.preferredName != null) return false;
        if (preferredAddress != null ? !preferredAddress.equals(person.preferredAddress) : person.preferredAddress != null) return false;
        if (attributes != null ? !attributes.equals(person.attributes) : person.attributes != null) return false;
        if (voided != null ? !voided.equals(person.voided) : person.voided != null) return false;
        if (deathdateEstimated != null ? !deathdateEstimated.equals(person.deathdateEstimated) : person.deathdateEstimated != null) return false;
        if (links != null ? !links.equals(person.links) : person.links != null) return false;
        return !(resourceVersion != null ? !resourceVersion.equals(person.resourceVersion) : person.resourceVersion != null);

    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (display != null ? display.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (birthdateEstimated != null ? birthdateEstimated.hashCode() : 0);
        result = 31 * result + (dead != null ? dead.hashCode() : 0);
        result = 31 * result + (deathDate != null ? deathDate.hashCode() : 0);
        result = 31 * result + (causeOfDeath != null ? causeOfDeath.hashCode() : 0);
        result = 31 * result + (preferredName != null ? preferredName.hashCode() : 0);
        result = 31 * result + (preferredAddress != null ? preferredAddress.hashCode() : 0);
        result = 31 * result + (attributes != null ? attributes.hashCode() : 0);
        result = 31 * result + (voided != null ? voided.hashCode() : 0);
        result = 31 * result + (deathdateEstimated != null ? deathdateEstimated.hashCode() : 0);
        result = 31 * result + (links != null ? links.hashCode() : 0);
        result = 31 * result + (resourceVersion != null ? resourceVersion.hashCode() : 0);
        return result;
    }
}
