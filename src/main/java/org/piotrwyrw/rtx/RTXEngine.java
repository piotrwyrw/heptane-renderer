package org.piotrwyrw.rtx;

import org.piotrwyrw.rtx.engine.Scene;
import org.piotrwyrw.rtx.engine.Vector;
import org.piotrwyrw.rtx.shapes.Sphere;
import org.piotrwyrw.rtx.ui.Interface;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class RTXEngine {

    private static Scene s;

    public static void main(String[] args) {
        new RTXEngine();
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

    public RTXEngine() {
        s = new Scene();
        for (int i = 0; i < 80; i++)
            s.add(new Sphere(new Vector(randomCoord() - Interface.DIMENSION / 2.0, 0, 100 + randomCoord()), 20 + Math.random() * 20, randomColor(), randVel(10.0)));

        new Interface();
    }

    public static Scene getScene() {
        return s;
    }

}
