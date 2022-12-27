package org.piotrwyrw.rtx.shapes;

import org.piotrwyrw.rtx.engine.Intersection;
import org.piotrwyrw.rtx.engine.Ray;
import org.piotrwyrw.rtx.engine.Vector;

import java.awt.*;

public abstract class Renderable {

    public abstract Vector normalVector(Vector point);
    public abstract Intersection intersect(Ray ray);
    public abstract Color baseColor();

}
