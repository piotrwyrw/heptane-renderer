package org.piotrwyrw.rtx.engine;

import org.piotrwyrw.rtx.shapes.Renderable;
import org.piotrwyrw.rtx.ui.Interface;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Scene {

    private BufferedImage result;
    private ArrayList<Renderable> objects;

    public Scene() {
        this.objects = new ArrayList<>();
        this.result = new BufferedImage(Interface.DIMENSION, Interface.DIMENSION, BufferedImage.TYPE_INT_RGB);
    }

    public void add(Renderable sphere) {
        this.objects.add(sphere);
    }

    public void render() {
        for (int y = 0; y < Interface.DIMENSION; y++)
            for (int x = 0; x < Interface.DIMENSION; x++) {
                Color c = Compute.trace(this, new Vector(0.0, 0.0, 0.0), new Vector(x - Interface.DIMENSION / 2.0, y - Interface.DIMENSION / 2.0, Interface.DIMENSION).normalize(), null, 0).getFirst();

                result.setRGB(x, y, c.getRGB());
            }
    }

    public ArrayList<Renderable> getObjects() {
        return objects;
    }

    public BufferedImage getResult() {
        return result;
    }

}
