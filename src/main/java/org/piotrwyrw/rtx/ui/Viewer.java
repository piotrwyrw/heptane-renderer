package org.piotrwyrw.rtx.ui;

import org.piotrwyrw.rtx.RTXEngine;
import org.piotrwyrw.rtx.engine.Scene;
import org.piotrwyrw.rtx.shapes.Sphere;

import javax.swing.*;
import java.awt.*;
public class Viewer extends JPanel {

    public Viewer() {
        super();
        new Thread(() -> {
            Scene s = RTXEngine.getScene();
            while (true) {
                repaint();
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

        g.drawImage(RTXEngine.getScene().getResult(), 0, 0, null);
    }
}
