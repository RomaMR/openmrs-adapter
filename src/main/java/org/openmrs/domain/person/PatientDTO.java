package org.openmrs.domain.person;

import java.util.List;

/**
 * Created by romanmudryi on 16.07.15.
 */
public class PatientDTO {

    private List<NamesDTO> names;

    private String gender;

    private String age;

    public PatientDTO() {
    }

    public List<NamesDTO> getNames() {
        return names;
    }

    public void setNames(List<NamesDTO> names) {
        this.names = names;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
