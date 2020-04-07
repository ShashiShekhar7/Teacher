package com.example.teacher.Model;

public class Postm {
    private String textpost;
    private String imagepost;
    private String videopost;

    public Postm() {
    }

    public Postm(String textpost, String imagepost, String videopost) {
        this.textpost = textpost;
        this.imagepost = imagepost;
        this.videopost = videopost;
    }

    public String getTextpost() {
        return textpost;
    }

    public void setTextpost(String textpost) {
        this.textpost = textpost;
    }

    public String getImagepost() {
        return imagepost;
    }

    public void setImagepost(String imagepost) {
        this.imagepost = imagepost;
    }

    public String getVideopost() {
        return videopost;
    }

    public void setVideopost(String videopost) {
        this.videopost = videopost;
    }
}
