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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TemplateResults)) return false;

        TemplateResults results1 = (TemplateResults) o;

        return !(results != null ? !results.equals(results1.results) : results1.results != null);

    }

    @Override
    public int hashCode() {
        return results != null ? results.hashCode() : 0;
    }
}
