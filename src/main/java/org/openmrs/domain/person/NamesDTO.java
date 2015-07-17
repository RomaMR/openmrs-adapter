package org.openmrs.domain.person;

/**
 * Created by romanmudryi on 16.07.15.
 */
public class NamesDTO {

    private String givenName;

    private String familyName;

    public NamesDTO() {
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }
}
