package com.ifts.planes;

public class Plane {
    String name;
    double length;
    double wingspan;
    String firstFlight;

    public Plane() {

    }

    public Plane(String name, double length, double wingspan, String firstFlight) {
        this.name = name;
        this.length = length;
        this.wingspan = wingspan;
        this.firstFlight = firstFlight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    public String getFirstFlight() {
        return firstFlight;
    }

    public void setFirstFlight(String firstFlight) {
        this.firstFlight = firstFlight;
    }

    public String toCSV() {
        return name + ";" + length + ";" + wingspan + ";" + firstFlight ;
    }

    @Override
    public String toString() {
        return "Plane{" + "name='" + name + '\'' + ", length=" + length + ", wingspan=" + wingspan + ", firstFlight='" + firstFlight + '}';
    }
}
