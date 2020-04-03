package id.pintaar.bab5.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hero {

    @SerializedName("response")
    private String response;
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("biography")
    private Biography biography;
    @SerializedName("image")
    private Image image;

    private String type;


    public Hero(String response, String id, String name, Biography biography, Image image, String type ) {
        this.response = response;
        this.id = id;
        this.name = name;
        this.biography = biography;
        this.image = image;
        this.type = type;
    }

    public Hero() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Biography getBiography() {
        return biography;
    }

    public void setBiography(Biography biography) {
        this.biography = biography;
    }


    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

}