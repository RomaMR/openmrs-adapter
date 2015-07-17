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
}
