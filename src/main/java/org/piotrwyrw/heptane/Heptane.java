package org.piotrwyrw.heptane;

import org.piotrwyrw.heptane.engine.Scene;
import org.piotrwyrw.heptane.engine.Vector;
import org.piotrwyrw.heptane.shapes.Shader;
import org.piotrwyrw.heptane.shapes.Sphere;
import org.piotrwyrw.heptane.ui.Interface;

import java.awt.*;

public class Heptane {

    private static Scene s;

    public static void main(String[] args) {
        new Heptane();
    }

    private double randomCoord() {
        return Math.random() * Interface.DIMENSION;
    }

    private Color randomColor() {
        return new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
    }

    private Vector randVel(double magnitude) {
        return new Vector(0.5 - Math.random(), 0.5 - Math.random(), 0.5 - Math.random()).normalize().multiply(magnitude);
    }

    public Heptane() {
        s = new Scene();

        // Ceiling
        s.add(new Sphere(new Vector(0.0, 505.0, 0.0), 500, Color.lightGray, Vector.zero(), Shader.DIFFUSE));

        // Floor
        s.add(new Sphere(new Vector(0.0, -505.0, 0.0), 500, Color.lightGray, Vector.zero(), Shader.DIFFUSE));

        // Right wall
        s.add(new Sphere(new Vector(505.0, 0.0, 0.0), 500, Color.decode("#6c5ce7"), Vector.zero(), Shader.DIFFUSE));

        // Left wall
        s.add(new Sphere(new Vector(-505.0, 0.0, 0.0), 500, Color.decode("#ff7675"), Vector.zero(), Shader.DIFFUSE));

        // Far wall
        s.add(new Sphere(new Vector(0.0, 0.0, -470.0), 500, Color.decode("#55efc4"), Vector.zero(), Shader.DIFFUSE));

        // The reflective sphere in the middle of the room
        for (int x = 0; x < 5; x ++)
            for (int y  = 0; y < 5; y ++) {
                s.add(new Sphere(new Vector(-5.0 + x * 2.3, -5.0 + y * 2.3, 25.0 - Math.random() * 5.0), 1.0, Color.WHITE, Vector.zero(), Shader.MIRROR));
            }

        // Ceiling lamp
        s.add(new Sphere(new Vector(1.5, -2.0, 15.0), 1.0, Color.decode("#e67e22"), Vector.zero(), Shader.LAMP));

        new Interface();
    }

    public static Scene getScene() {
        return s;
    }

}
