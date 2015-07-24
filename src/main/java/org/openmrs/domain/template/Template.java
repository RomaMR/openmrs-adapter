package org.openmrs.domain.template;

import java.util.List;

/**
 * Created by romanmudryi on 16.07.15.
 */
public class Template {

    private String uuid;

    private String display;

    private List<TemplateLinks> links;

    public Template() {
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

    public List<TemplateLinks> getLinks() {
        return links;
    }

    public void setLinks(List<TemplateLinks> links) {
        this.links = links;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Template)) return false;

        Template template = (Template) o;

        if (uuid != null ? !uuid.equals(template.uuid) : template.uuid != null) return false;
        if (display != null ? !display.equals(template.display) : template.display != null) return false;
        return !(links != null ? !links.equals(template.links) : template.links != null);

    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (display != null ? display.hashCode() : 0);
        result = 31 * result + (links != null ? links.hashCode() : 0);
        return result;
    }
}
