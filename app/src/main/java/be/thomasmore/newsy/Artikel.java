package be.thomasmore.newsy;

import java.util.Date;

public class Artikel {
    public String titel;
    public String url;
    public Date published;
    public String source;
    public String sourceUrl;

    public Artikel() {
    }

    public Artikel(String titel, String url, Date published, String source, String sourceUrl) {
        this.titel = titel;
        this.url = url;
        this.published = published;
        this.source = source;
        this.sourceUrl = sourceUrl;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
    @Override
    public String toString() {
        return titel;
    }
}
