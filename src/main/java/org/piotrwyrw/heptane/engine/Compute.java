package org.piotrwyrw.heptane.engine;

import org.piotrwyrw.heptane.Pair;
import org.piotrwyrw.heptane.shapes.Renderable;

import java.awt.*;

public class Compute {

    // Limit the amount of light bounces (reflections)
    public static int MAX_BOUNCES = 2;

    /**
     * Apply the general formula for solving quadratics:
     * (-b +- sqrt(b^2 - 4ac)) / 2a
     */
    public static double quadratic(double a, double b, double c) {
        double discriminant = b * b - 4 * a * c;

        // This quadratic has no solution
        if (discriminant < 0)
            return -1.0;

        double d = (-b - Math.sqrt(discriminant)) / (2 * a);

        if (d > 0.0)
            return d;

        d = (-b + Math.sqrt(discriminant)) / (2 * a);

        if (d >= 0.0)
            return d;

        return -1.0;

    }

    public static Color brightnessAdjusted(Color color, double brightness) {
        return new Color(
                (int) (color.getRed() * brightness),
                (int) (color.getGreen() * brightness),
                (int) (color.getBlue() * brightness)
        );
    }

    public static Pair<Renderable, Intersection> findIntersectingSphere(Scene s, Vector org, Vector dir, Renderable ignore) {
        Ray ray = new Ray(org, dir);

        // Find the intersecting sphere
        boolean hit = false;
        Pair<Renderable, Double> closest = null;
        Intersection ints = null;

        Color c = Color.WHITE;

        for (Renderable object : s.getObjects()) {

            if (object.equals(ignore))
                continue;

            Intersection intersection = object.intersect(ray);

            if (intersection.isPresent()) {
                double dst = intersection.getDistance();

                if (closest == null) {
                    closest = new Pair<>(object, dst);
                    ints = intersection;
                }


                if (closest.getLast() > dst) {
                    closest = new Pair<>(object, dst);
                    ints = intersection;
                }

            }
        }

        if (closest == null)
            return null;

        Renderable closestSphere = closest.getFirst();

        return new Pair<>(closestSphere, ints);
    }

    public static Pair<Color, Renderable> trace(Scene s, Vector org, Vector dir, Renderable ignore, int bounces) {

        Pair<Renderable, Intersection> intersecting = findIntersectingSphere(s, org, dir, ignore);

        Color c = Color.WHITE;

        if (intersecting == null)
            return new Pair<>(Color.BLACK, null);

        Intersection ints = intersecting.getLast();
        Renderable object = intersecting.getFirst();

        // Point of intersection
        Vector ip = ints.getRay().pointAt(ints.getDistance());

        // The sphere's normal vector
        Vector n = object.normalVector(ip).normalize();

        // Shade (color)
        c = object.baseColor();

        if (bounces > MAX_BOUNCES)
            return new Pair<>(object.baseColor(), object);

        c = mix(object.baseColor(), trace(s, ip, n, object, bounces + 1).getFirst());

        return new Pair<>(c, object);
    }

    public static Color mix(Color a, Color b) {
        return new Color(
                (int) (a.getRed() + b.getRed()) / 2,
                (int) (a.getGreen() + b.getGreen()) / 2,
                (int) (a.getBlue() + b.getBlue()) / 2
        );
    }

}
