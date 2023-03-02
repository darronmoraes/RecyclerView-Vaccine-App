package com.example.recyclerviewapp;

public class VaccineModel {

    // model variables
    private String title;
    private int image;

    // Constructor
    public VaccineModel(String title, int image) {
        this.title = title;
        this.image = image;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}
