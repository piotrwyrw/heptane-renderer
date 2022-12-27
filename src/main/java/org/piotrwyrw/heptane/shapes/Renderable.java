package org.piotrwyrw.heptane.shapes;

import org.piotrwyrw.heptane.engine.Intersection;
import org.piotrwyrw.heptane.engine.Ray;
import org.piotrwyrw.heptane.engine.Vector;

import java.awt.*;

public abstract class Renderable {

    public abstract Vector normalVector(Vector point);
    public abstract Intersection intersect(Ray ray);
    public abstract Color baseColor();

}
