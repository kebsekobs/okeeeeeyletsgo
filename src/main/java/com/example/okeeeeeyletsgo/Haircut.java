package com.example.okeeeeeyletsgo;

public class Haircut {
    private final String nameOfHaircut;
    private final String colourOfHaircut;
    private final String hairLength;
    private final String facialHair;
    private final String review;
    private final String cutePhoto;
    private final int rate;

    public Haircut(String nameOfHaircut, String ColourOfHaircut, String hairLength, String facialHair, String review, String cutePhoto, int rate) {
        this.nameOfHaircut = nameOfHaircut;
        this.colourOfHaircut = ColourOfHaircut;
        this.hairLength = hairLength;
        this.facialHair = facialHair;
        this.review = review;
        this.cutePhoto = cutePhoto;
        this.rate = rate;
    }

    public String getNameOfHaircut() {
        return nameOfHaircut;
    }

    public String getColourOfHaircut() {
        return colourOfHaircut;
    }

    public String getHairLength() {
        return hairLength;
    }

    public String getFacialHair() {
        return facialHair;
    }

    public String getReview() {
        return review;
    }

    public String getCutePhoto() {
        return cutePhoto;
    }

    public int getRate() {
        return rate;
    }
}
