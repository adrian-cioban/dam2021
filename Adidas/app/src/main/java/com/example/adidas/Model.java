package com.example.adidas;

import java.util.Arrays;

public class Model {
    private int time;
    private String difficulty;
    private String title;
    private Integer image;
    private String[] tags;

    public Model(int time, String difficulty, String title, Integer image) {
        this.time = time;
        this.difficulty = difficulty;
        this.title = title;
        this.image = image;
    }

    public Model(int time, String difficulty, String title, Integer image, String[] tags) {
        this.time = time;
        this.difficulty = difficulty;
        this.title = title;
        this.image = image;
        this.tags = tags;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Model{" +
                "time=" + time +
                ", difficulty='" + difficulty + '\'' +
                ", title='" + title + '\'' +
                ", image=" + image +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}
