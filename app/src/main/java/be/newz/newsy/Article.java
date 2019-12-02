package be.newz.newsy;

import java.util.Date;

public class Article {
    private String title;
    private String url;
    private String published;
    private String source;
    private String sourceUrl;

    public Article() {
    }

    public Article(String title, String url, String published, String source, String sourceUrl) {
        this.title = title;
        this.url = url;
        this.published = published;
        this.source = source;
        this.sourceUrl = sourceUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
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
        return title;
    }
}
