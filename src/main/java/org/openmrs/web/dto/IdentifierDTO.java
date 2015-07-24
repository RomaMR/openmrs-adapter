package org.openmrs.web.dto;

/**
 * Created by romanmudryi on 22.07.15.
 */
public class IdentifierDTO {

    private String identifier;

    private String identifierType;

    private String location;

    private Boolean preferred;

    public IdentifierDTO() {
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifierType() {
        return identifierType;
    }

    public void setIdentifierType(String identifierType) {
        this.identifierType = identifierType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Boolean getPreferred() {
        return preferred;
    }

    public void setPreferred(Boolean preferred) {
        this.preferred = preferred;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IdentifierDTO)) return false;

        IdentifierDTO that = (IdentifierDTO) o;

        if (identifier != null ? !identifier.equals(that.identifier) : that.identifier != null) return false;
        if (identifierType != null ? !identifierType.equals(that.identifierType) : that.identifierType != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        return !(preferred != null ? !preferred.equals(that.preferred) : that.preferred != null);

    }

    @Override
    public int hashCode() {
        int result = identifier != null ? identifier.hashCode() : 0;
        result = 31 * result + (identifierType != null ? identifierType.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (preferred != null ? preferred.hashCode() : 0);
        return result;
    }
}
