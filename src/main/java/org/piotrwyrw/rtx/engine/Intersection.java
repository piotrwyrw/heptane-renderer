package org.piotrwyrw.rtx.engine;

public class Intersection {

    private Ray ray;
    private double distance;
    private boolean present;

    public Intersection(Ray ray, double distance, boolean present) {
        this.ray = ray;
        this.distance = distance;
        this.present = present;
    }

    public Ray getRay() {
        return ray;
    }

    public void setRay(Ray ray) {
        this.ray = ray;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public static Intersection none(Ray ray) {
        return new Intersection(ray, 0.0, false);
    }

}
