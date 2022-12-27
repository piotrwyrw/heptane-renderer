package org.piotrwyrw.heptane.engine;

public class Ray {

    private Vector origin;
    private Vector direction;

    public Ray(Vector origin, Vector direction) {
        this.origin = origin;
        this.direction = direction;
    }

    public Vector getOrigin() {
        return origin;
    }

    public void setOrigin(Vector origin) {
        this.origin = origin;
    }

    public Vector getDirection() {
        return direction;
    }

    public void setDirection(Vector direction) {
        this.direction = direction;
    }

    public Vector pointAt(double distance) {
        // O + t * D
        return new Vector(direction).multiply(distance).add(origin);
    }

}
