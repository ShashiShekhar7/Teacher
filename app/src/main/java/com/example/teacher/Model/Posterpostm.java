package com.example.teacher.Model;

public class Posterpostm {
    private String imagepost;
    private String textpost;
    private String videopost;

    public Posterpostm() {
    }

    public Posterpostm(String imagepost, String textpost, String videopost) {
        this.imagepost = imagepost;
        this.textpost = textpost;
        this.videopost = videopost;
    }

    public String getImagepost() {
        return imagepost;
    }

    public void setImagepost(String imagepost) {
        this.imagepost = imagepost;
    }

    public String getTextpost() {
        return textpost;
    }

    public void setTextpost(String textpost) {
        this.textpost = textpost;
    }

    public String getVideopost() {
        return videopost;
    }

    public void setVideopost(String videopost) {
        this.videopost = videopost;
    }
}
