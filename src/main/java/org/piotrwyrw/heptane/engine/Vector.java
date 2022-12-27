package org.piotrwyrw.heptane.engine;

public class Vector {

    private double x;
    private double y;
    private double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector(Vector another) {
        this.x = another.x;
        this.y = another.y;
        this.z = another.z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Vector multiply(double d) {
        this.x *= d;
        this.y *= d;
        this.z *= d;

        return this;
    }

    public Vector divide(double d) {
        this.x /= d;
        this.y /= d;
        this.z /= d;

        return this;
    }

    public Vector add(Vector another) {
        this.x += another.getX();
        this.y += another.getY();
        this.z += another.getZ();

        return this;
    }

    public Vector subtract(Vector another) {
        this.x -= another.getX();
        this.y -= another.getY();
        this.z -= another.getZ();

        return this;
    }

    public double dot(Vector another) {
        return this.x * another.getX() + this.y * another.getY() + this.z * another.getZ();
    }

    public double magnitudeSquared() {
        return dot(this);
    }

    public double magnitude() {
        return Math.sqrt(magnitudeSquared());
    }

    public Vector normalize() {
        double d = magnitude();
        if (d == 0.0)
            return this;
        divide(d);

        return this;
    }

    public static double distanceBetween(Vector a, Vector b) {
        return Math.sqrt(
                (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y) + (a.z - b.z) * (a.z - b.z)
        );
    }

    public static Vector zero() {
        return new Vector(0.0, 0.0, 0.0);
    }

}
