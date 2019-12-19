package be.newz.newsy.help;

public class Page {
    private String title;
    private Integer layoutFile;

    public Page() {
    }

    public Page(String title, Integer layoutFile) {
        this.title = title;
        this.layoutFile = layoutFile;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLayoutFile() {
        return layoutFile;
    }

    public void setLayoutFile(Integer layoutFile) {
        this.layoutFile = layoutFile;
    }
}
