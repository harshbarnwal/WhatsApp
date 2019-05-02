package com.tech4use.whatsapp;


public class Custom{

    String title;
    String subtitle;
    Integer image;

    public Custom (String title, String subtitle, Integer image) {

        this.title = title;
        this.subtitle = subtitle;
        this.image = image;

    }

    //returning all the values
    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Integer getImage() {
        return image;
    }

}
