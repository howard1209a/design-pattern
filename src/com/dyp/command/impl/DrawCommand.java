package com.dyp.command.impl;

import com.dyp.command.Command;
import com.dyp.command.Drawable;

import java.awt.*;

/**
 * @Description: TODO
 */
public class DrawCommand implements Command {
    protected Drawable drawable;
    private Point position;

    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    @Override
    public void execute() {
        drawable.draw(position.x, position.y);
    }
}
