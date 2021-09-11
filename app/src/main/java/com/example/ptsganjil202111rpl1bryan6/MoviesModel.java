package com.example.ptsganjil202111rpl1bryan6;

public class MoviesModel {

    private String name;
    private String description;
    private String releaseDate;
    private String image;
    private String header;
    private String popularity;

    public MoviesModel(String name, String description, String releaseDate, String image, String header, String popularity) {
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.image = image;
        this.header = header;
        this.popularity = popularity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }
}
