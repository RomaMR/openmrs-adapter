package org.openmrs.domain.template;

import java.util.List;

/**
 * Created by romanmudryi on 16.07.15.
 */
public class TemplateResults {

    private List<Template> results;

    public TemplateResults() {
    }

    public List<Template> getResults() {
        return results;
    }

    public void setResults(List<Template> results) {
        this.results = results;
    }
}
