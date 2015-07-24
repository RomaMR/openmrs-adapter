package org.openmrs.domain.template;

/**
 * Created by romanmudryi on 16.07.15.
 */
public class TemplateLinks {

    private String rel;

    private String uri;

    public TemplateLinks() {
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TemplateLinks)) return false;

        TemplateLinks that = (TemplateLinks) o;

        if (rel != null ? !rel.equals(that.rel) : that.rel != null) return false;
        return !(uri != null ? !uri.equals(that.uri) : that.uri != null);

    }

    @Override
    public int hashCode() {
        int result = rel != null ? rel.hashCode() : 0;
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        return result;
    }
}
