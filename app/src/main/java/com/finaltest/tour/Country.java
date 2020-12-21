package com.finaltest.tour;

public class Country {

    private String con;
    private String concap;
    private String conimg;


    public Country(String con, String concap, String conimg) {
        this.con = con;
        this.concap = concap;
        this.conimg = conimg;
    }

    public String getCon() {
        return con;
    }

    public String getConcap() {
        return concap;
    }

    public String getConimg() {
        return conimg;
    }
}
