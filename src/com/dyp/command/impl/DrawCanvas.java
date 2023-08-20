package com.dyp.command.impl;

import com.dyp.command.Drawable;

import java.awt.*;

/**
 * @Description: TODO
 */
public class DrawCanvas extends Canvas implements Drawable {
    private Color color = Color.red;
    private int redius = 6;
    private MacroCommand history;

    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    @Override
    public void paint(Graphics g) {
        history.execute();
    }

    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics();
        g.setColor(color);
        g.fillOval(x - redius, y - redius, redius * 2, redius * 2);
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }
}
