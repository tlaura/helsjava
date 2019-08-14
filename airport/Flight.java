package com.company;

public class Flight {
    private Plane plane;
    private String codes;

    public Flight(Plane plane, String codes){
        this.plane = plane;
        this.codes = codes;
    }

    public Plane getP(){
        return this.plane;
    }

    public String getCodes(){
        return this.codes;
    }
}
