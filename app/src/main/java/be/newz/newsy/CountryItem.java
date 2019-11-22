package be.newz.newsy;

public class CountryItem {
    private String country;
    private String language;
    private int flagImage;

    public CountryItem() {
    }

    public CountryItem(String country, String language, int flagImage) {
        this.country = country;
        this.language = language;
        this.flagImage = flagImage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getFlagImage() {
        return flagImage;
    }

    public void setFlagImage(int flagImage) {
        this.flagImage = flagImage;
    }
}
