package org.piotrwyrw.heptane.shapes;

import org.piotrwyrw.heptane.engine.*;

import java.awt.*;

public class Sphere extends Renderable {

    private Vector center;
    private double radius;
    private Color color;
    private Vector velocity;
    private Shader shader;

    public Sphere(Vector center, double radius, Color color, Vector velocity, Shader shader) {
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.velocity = velocity;
        this.shader = shader;
    }

    public Vector getCenter() {
        return center;
    }

    public void setCenter(Vector center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Vector getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector velocity) {
        this.velocity = velocity;
    }

    public Shader getShader() {
        return shader;
    }

    public void setShader(Shader shader) {
        this.shader = shader;
    }

    public void update() {
        this.center.add(velocity);
    }

    @Override
    public Vector normalVector(Vector point) {
        return new Vector(point).subtract(center);
    }

    @Override
    public Intersection intersect(Ray ray) {

        // P = O - C
        Vector p = new Vector(ray.getOrigin()).subtract(center);

        // D * D
        var a = new Vector(ray.getDirection()).dot(ray.getDirection());

        // 2 * P * D
        var b = new Vector(p).dot(ray.getDirection()) * 2.0;

        // P * P - r^2
        var c = new Vector(p).dot(p) - radius * radius;

        // Compute the quadratic
        double solution = Compute.quadratic(a, b, c);

        if (solution < 0.0)
            return Intersection.none(ray);

        return new Intersection(ray, solution, true);
    }

    @Override
    public Color baseColor() {
        return this.color;
    }

    @Override
    public Shader shader() {
        return this.shader;
    }
}
