package com.dyp.command.impl;

import com.dyp.command.Command;
import com.dyp.command.Drawable;

import java.awt.*;

/**
 * @Description: TODO
 */
public class ColorCommand implements Command {
    protected Drawable drawable;
    private Color color;

    public ColorCommand(Drawable drawable, Color color) {
        this.drawable = drawable;
        this.color = color;
    }

    @Override
    public void execute() {
        drawable.setColor(color);
    }
}
