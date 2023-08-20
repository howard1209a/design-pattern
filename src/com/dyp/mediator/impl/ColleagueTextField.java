package com.dyp.mediator.impl;

import com.dyp.mediator.Colleague;
import com.dyp.mediator.Mediator;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * @author howard
 * @version 1.0
 */
public class ColleagueTextField extends TextField implements TextListener,Colleague {
    private Mediator mediator;

    public ColleagueTextField(String text, int columns) throws HeadlessException {
        super(text, columns);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
        setBackground(enabled?Color.WHITE:Color.LIGHT_GRAY);
    }


    @Override
    public void textValueChanged(TextEvent e) {
        mediator.colleagueChanged();
    }
}
