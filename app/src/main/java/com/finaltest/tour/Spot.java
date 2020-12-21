package com.finaltest.tour;

public class Spot {

    private String spotname;
    private double spotfare;
    private String spotimg;
    private String con;


    public Spot(String spotname, double spotfare, String spotimg, String con) {

        this.spotname = spotname;
        this.spotfare = spotfare;
        this.spotimg = spotimg;
        this.con = con;
    }

    public String getSpotname() {
        return spotname;
    }

    public double getSpotfare() {
        return spotfare;
    }

    public String getSpotimg() {
        return spotimg;
    }

    public String getCon() {
        return con;
    }
}
