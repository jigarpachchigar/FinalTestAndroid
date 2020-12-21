package com.finaltest.tour;

public class Capital {

    private String conname;
    private String concapital;
    private String conimg;
    private String con;


    public Capital(String conname, String concapital, String conimg,String con) {

        this.conname = conname;
        this.concapital = concapital;
        this.conimg = conimg;
        this.con = con;
    }

    public String getConname() {
        return conname;
    }

    public String getConcapital() {
        return concapital;
    }

    public String getConimg() {
        return conimg;
    }

    public String getCon() {
        return con;
    }
}
