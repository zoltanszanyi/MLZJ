package hu.unideb.inf;

import java.util.ArrayList;

public class Location {
    private int locID;
    private float fullness; // telítettség százalékban
    private int max; //maximum férőhely
    private int nowin; //bentlévő járművek
    private String address; //cím
    private String name;

    public Location(int locID, int max, int nowin, String address, String name) {
        this.locID = locID;
        this.max = max;
        this.nowin = nowin;
        this.address = address;
        this.name = name;
    }

    public Location() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocID() {
        return locID;
    }

    public void setLocID(int locID) {
        this.locID = locID;
    }

    public float getFullness() {
        return fullness;
    }

    public void setFullness(float fullness) {
        this.fullness = (getNowin()/getMax())*100;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getNowin() {
        return nowin;
    }

    public void setNowin(int nowin) {
        this.nowin = nowin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Location> locationsClass = new ArrayList<>();

}
