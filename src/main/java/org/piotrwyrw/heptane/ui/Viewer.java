package org.piotrwyrw.heptane.ui;

import org.piotrwyrw.heptane.Heptane;
import org.piotrwyrw.heptane.engine.Scene;

import org.piotrwyrw.heptane.shapes.Sphere;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;

public class Viewer extends JPanel {

    public Viewer() {
        super();
        new Thread(() -> {
            Scene s = Heptane.getScene();
            AtomicReference<Double> angle = new AtomicReference<>(0.0);
            while (true) {
                repaint();
                System.out.println("Rendering ..");
                s.render();
                s.getObjects().forEach((e) -> {
                    if (e instanceof Sphere)
                        ((Sphere)e).update();
                });
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.decode("#2c2c54"));
        g.fillRect(0, 0, Interface.DIMENSION, Interface.DIMENSION);

        g.drawImage(Heptane.getScene().getResult(), 0, 0, null);
    }
}
