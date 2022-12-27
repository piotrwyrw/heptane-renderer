package org.piotrwyrw.rtx.ui;

import javax.swing.*;

public class Interface extends JFrame {

    public static final int DIMENSION = 950;

    public Interface() {
        super("Raytracer");
        setSize(DIMENSION, DIMENSION);
        setResizable(false);
        setLocationRelativeTo(null);
        add(new Viewer());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

}
