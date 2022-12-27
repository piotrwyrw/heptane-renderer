package org.piotrwyrw.heptane;

import org.piotrwyrw.heptane.engine.Scene;
import org.piotrwyrw.heptane.engine.Vector;
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
        for (int i = 0; i < 80; i++)
            s.add(new Sphere(new Vector(randomCoord() - Interface.DIMENSION / 2.0, 0, 100 + randomCoord()), 20 + Math.random() * 20, randomColor(), randVel(10.0)));

        new Interface();
    }

    public static Scene getScene() {
        return s;
    }

}
